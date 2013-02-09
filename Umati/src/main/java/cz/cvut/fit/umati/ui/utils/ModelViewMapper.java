package cz.cvut.fit.umati.ui.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;

import com.vaadin.data.Property;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.CustomComponent;

import cz.cvut.fit.umati.model.IQuestion;
import cz.cvut.fit.umati.ui.annotations.Map;
import cz.cvut.fit.umati.ui.annotations.MultipleMap;
import cz.cvut.fit.umati.ui.annotations.View;

public class ModelViewMapper {

	/**
	 * TODO: doc it
	 * 
	 * @param model
	 * @return
	 */
	public static CustomComponent map(ApplicationContext applicationContext, IQuestion model) {
		Class<? extends CustomComponent> viewClass;
		CustomComponent view;

		// check and get annotation
		if (model.getClass().isAnnotationPresent(View.class)) {
			// Get view class from annotation in model class
			viewClass = model.getClass().getAnnotation(View.class).viewClass();

			// Look for actual Spring Bean
			view = applicationContext.getBean(viewClass);

			// TODO: mapping getters from view (this side is regulated) + check
			// existence + type correcteness
			Class<?> actualClass = model.getClass();
			while (!Object.class.equals(actualClass)) {

				for (Field modelField : actualClass.getDeclaredFields()) {
					boolean binded = false;
					
					// Check if it has getters and setters
					PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(actualClass, modelField.getName());
					if (propertyDescriptor == null || propertyDescriptor.getReadMethod() == null || propertyDescriptor.getWriteMethod() == null) {
						continue;
					}

					// Prepare property
					Property property = createProperty(model, modelField.getName());

					// Try to map by MultipleMap annotation
					if (modelField.isAnnotationPresent(MultipleMap.class) && !binded) {
						for (Map annotation : modelField.getAnnotation(MultipleMap.class).value()) {
							String fieldName = annotation.viewField();

							binded = mapModelToView(view, property, fieldName);
							
							// If binded don't have to go through
							if (binded) {
								break;
							}
						}
					}

					// Try to map by Map annotation
					if (modelField.isAnnotationPresent(Map.class) && !binded) {
						String fieldName = modelField.getAnnotation(Map.class).viewField();

						binded = mapModelToView(view, property, fieldName);
					}

					// Try to map by name equivalence
					if (!binded) {
						binded = mapModelToView(view, property, modelField.getName());
					}
				}

				actualClass = actualClass.getSuperclass();
			}

			// Measure sucessfulness - unconnected AbstractFields !!!
			for (PropertyDescriptor propertyDescriptor : BeanUtils.getPropertyDescriptors(viewClass)) {
				if (AbstractField.class.isAssignableFrom(propertyDescriptor.getPropertyType())) {
					try {
						Object object = propertyDescriptor.getReadMethod().invoke(view, (Object[]) null);
						if (object instanceof AbstractField) {
							AbstractField field = (AbstractField) object;

							if (field.getPropertyDataSource() != null) {
								System.out.println("Field: " + propertyDescriptor.getName() + " is binded succesfully");
							} else {
								System.out.println("Field: " + propertyDescriptor.getName() + " is NOT binded");
							}
						}

					} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}

			return view;
		} else {
			return null;

		}
	}

	/**
	 * TODO: doc it
	 * 
	 * @param model
	 * @param propertyName
	 * @return
	 */
	private static MethodProperty<?> createProperty(IQuestion model, String propertyName) {
		return new MethodProperty<Object>(model, propertyName);
	}

	/**
	 * TODO: doc it
	 * 
	 * @param view
	 * @param property
	 * @param fieldName
	 * @return
	 */
	private static boolean mapModelToView(CustomComponent view, Property property, String fieldName) {
		PropertyDescriptor viewField = BeanUtils.getPropertyDescriptor(view.getClass(), fieldName);

		if (viewField == null) {
			return false;
		}

		try {
			Object abstractFieldObject = viewField.getReadMethod().invoke(view, (Object[]) null);

			// Check for right data type
			if (abstractFieldObject instanceof AbstractField) {
				AbstractField abstractField = (AbstractField) abstractFieldObject;
				abstractField.setPropertyDataSource(property);
			}
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return false;
		}

		// If everythink is ok, return true
		return true;
	}
}
