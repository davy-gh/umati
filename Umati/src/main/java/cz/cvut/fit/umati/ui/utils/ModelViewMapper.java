package cz.cvut.fit.umati.ui.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;

import com.vaadin.addon.beanvalidation.BeanValidationValidator;
import com.vaadin.data.Property;
import com.vaadin.data.Validator.EmptyValueException;
import com.vaadin.data.Validator.InvalidValueException;
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
	 * @param component
	 */
	public static void commitAll(CustomComponent component) throws EmptyValueException {
		List<AbstractField> fieldList = new ArrayList<AbstractField>();

		for (Field field : component.getClass().getDeclaredFields()) {
			if (AbstractField.class.isAssignableFrom(field.getType())) {
				try {
					field.setAccessible(true);
					Object object = field.get(component);
					if (object instanceof AbstractField) {
						fieldList.add((AbstractField) object);
					}

				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		// Test validation
		for (AbstractField abstractField : fieldList) {
			try {
				abstractField.validate();
			} catch (InvalidValueException e) {
				throw e;
			}
		}

		// Finally, commit all
		for (AbstractField abstractField : fieldList) {
			abstractField.commit();
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

		// mapping getters from view (this side is regulated) + check existence
		// + type correcteness
		if (view != null) {
			Class<?> actualClass = model.getClass();
			while (!Object.class.equals(actualClass)) {

				for (Field modelField : actualClass.getDeclaredFields()) {
					// Check if it has getters and setters
					PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(actualClass, modelField.getName());
					if (propertyDescriptor == null || propertyDescriptor.getReadMethod() == null || propertyDescriptor.getWriteMethod() == null) {
						continue;
					}

					/*
					 * Find appropriate abstract field
					 */

					// View Abstract Field
					AbstractField abstractField = findViewField(view, modelField);

					if (abstractField == null) {
						for (CustomComponent viewComponent : findAllSubView(view)) {
							abstractField = findViewField(viewComponent, modelField);
							
							if (abstractField != null) {
								break;
							}
						}
					}

					/*
					 * Bind property & Extra features
					 */
					if (abstractField != null) {
						// Prepare property
						Property property = createProperty(model, modelField.getName());

						// Bind property to abstractField
						abstractField.setPropertyDataSource(property);

						// Bind validator
						abstractField.removeAllValidators();
						BeanValidationValidator validator = new BeanValidationValidator(model.getClass(), modelField.getName());
						abstractField.addValidator(validator);
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
						// TODO: validatory!!!
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
	 * @return
	 */
	private static List<CustomComponent> findAllSubView(CustomComponent view) {
		List<CustomComponent> subViewList = new ArrayList<CustomComponent>();

		// Breath-First traverse
		for (Field field : view.getClass().getDeclaredFields()) {
			if (field.getType().equals(CustomComponent.class)) {
				try {
					CustomComponent viewComponent = (CustomComponent) field.get(view);

					subViewList.add(viewComponent);
					subViewList.addAll(findAllSubView(viewComponent));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return subViewList;
	}

	/**
	 * TODO: doc it
	 * 
	 * @param view
	 * @param fieldName
	 * @return
	 */
	private static AbstractField findViewField(CustomComponent view, Field modelField) {
		// Name of view field
		String viewFieldName = null;

		// View Abstract Field
		AbstractField abstractField = null;

		// Try to map by MultipleMap annotation
		if (modelField.isAnnotationPresent(MultipleMap.class) && abstractField == null) {
			for (Map annotation : modelField.getAnnotation(MultipleMap.class).value()) {
				viewFieldName = annotation.viewField();

				abstractField = findViewFieldInClass(view, viewFieldName);

				// If binded don't have to go through
				if (abstractField != null) {
					break;
				}
			}
		}

		// Try to map by Map annotation
		if (modelField.isAnnotationPresent(Map.class) && abstractField == null) {
			viewFieldName = modelField.getAnnotation(Map.class).viewField();

			abstractField = findViewFieldInClass(view, viewFieldName);
		}

		// Try to map by name equivalence
		if (abstractField == null) {
			viewFieldName = modelField.getName();

			abstractField = findViewFieldInClass(view, viewFieldName);
		}

		return abstractField;
	}

	/**
	 * TODO: doc it
	 * 
	 * @param view
	 * @param fieldName
	 * @return
	 */
	private static AbstractField findViewFieldInClass(CustomComponent view, String fieldName) {
		AbstractField abstractField = null;

		try {
			Field field = view.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);

			// Get the value
			Object abstractFieldObject = field.get(view);

			// Check for right data type
			if (abstractFieldObject instanceof AbstractField) {
				abstractField = (AbstractField) abstractFieldObject;
			} else {
				return null;
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			return null;
		}

		return abstractField;
	}
}
