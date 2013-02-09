package cz.cvut.fit.umati.ui.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;

import com.vaadin.data.Property;
import com.vaadin.data.Validator.EmptyValueException;
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
	 * @param applicationContext
	 * @param model
	 * @return
	 */
	public static CustomComponent findViewClass(ApplicationContext applicationContext, IQuestion model) {
		// check and get annotation
		if (model.getClass().isAnnotationPresent(View.class)) {
			// Get view class from annotation in model class
			Class<? extends CustomComponent> viewClass = model.getClass().getAnnotation(View.class).viewClass();

			return applicationContext.getBean(viewClass);
		} else {
			return null;
		}
	}

	/**
	 * TODO: doc it
	 * 
	 * @param component
	 */
	public static void commitAll(CustomComponent component) {
		for (Field field : component.getClass().getDeclaredFields()) {
			if (AbstractField.class.isAssignableFrom(field.getType())) {
				try {
					field.setAccessible(true);
					Object object = field.get(component);
					if (object instanceof AbstractField) {
						AbstractField abstractField = (AbstractField) object;

						abstractField.commit();
					}

				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				} catch (EmptyValueException e) {
					//TODO: validatory!!!
					System.out.println("Validacni exception!!!!!");
				}
			}
		}
	}

	/**
	 * TODO: doc it
	 * 
	 * @param model
	 * @return
	 */
	public static CustomComponent map(ApplicationContext applicationContext, IQuestion model) {
		CustomComponent view = findViewClass(applicationContext, model);

		// TODO: mapping getters from view (this side is regulated) + check
		// existence + type correcteness
		if (view != null) {
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
							String viewFieldName = annotation.viewField();

							binded = mapModelToView(view, property, viewFieldName);

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
			for (Field viewField : view.getClass().getDeclaredFields()) {
				if (AbstractField.class.isAssignableFrom(viewField.getType())) {
					try {
						viewField.setAccessible(true);
						Object object = viewField.get(view);
						if (object instanceof AbstractField) {
							AbstractField abstractField = (AbstractField) object;

							if (abstractField.getPropertyDataSource() != null) {
								System.out.println("Field: " + viewField.getName() + " is binded succesfully");
							} else {
								System.out.println("Field: " + viewField.getName() + " is NOT binded");
								abstractField.setEnabled(false);
							}
						}

					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					} catch (EmptyValueException e) {
						//TODO: validatory!!!
						System.out.println("Validacni exception!!!!!");
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
		try {
			Field field = view.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);

			// Get the value
			Object abstractFieldObject = field.get(view);

			// Check for right data type
			if (abstractFieldObject instanceof AbstractField) {
				AbstractField abstractField = (AbstractField) abstractFieldObject;
				abstractField.setPropertyDataSource(property);
			}
		} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			return false;
		}

		// If everythink is ok, return true
		return true;
	}
}
