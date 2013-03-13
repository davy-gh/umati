package cz.cvut.fit.umati.model;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.metadata.BeanDescriptor;
import javax.validation.metadata.PropertyDescriptor;

import cz.cvut.fit.umati.ui.annotations.Map;
import cz.cvut.fit.umati.ui.annotations.MultipleMap;

public abstract class AbstractQuestion<T extends IQuestion> implements IQuestion {
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "endPointsType")
	private Class<? extends T> entitiesClass;

	/**
	 * TODO: doc it
	 */
	@MultipleMap(value = { @Map(viewField = "numericInputField"), @Map(viewField = "numberOfParameters") })
	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	private int numberOfEntities;
	
	/**
	 * TODO: doc it
	 */
	private final List<T> subEntities = new ArrayList<T>();

	/*
	 * Getters & Setters
	 */
	public int getNumberOfEntities() {
		return numberOfEntities;
	}
	
	public void setNumberOfEntities(int numberOfEntities) throws QuestionListException {
		this.numberOfEntities = numberOfEntities;
		
		
		// Necessary to keep in consistent state
		rebuildObject();
	}

	public Class<? extends T> getEntitiesClass() {
		return entitiesClass;
	}

	public void setEntitiesClass(Class<? extends T> entitiesClass) throws QuestionListException {
		this.entitiesClass = entitiesClass;
		
		// Necessary to keep in consistent state
		rebuildObject();
	}
	
	public List<T> getSubEntities() {
		return subEntities;
	}
	
	/*
	 * Private Business Methods
	 */

	/**
	 * TODO: doc it
	 * 
	 * @param parameterNumber
	 * @throws QuestionListException
	 */
	private void rebuildObject() throws QuestionListException {
		// If the class is changed then clean all entities before
		if (entitiesClass != null && subEntities.size() > 0) {
			for (T subEntity : subEntities) {
				if (!entitiesClass.equals(subEntity.getClass())) {
					// Clean the queue
					subEntities.clear();
					
					//...and break the cycle
					break;
				}
			}
		}
		
		if (subEntities.size() < numberOfEntities) {
			// It's bigger = add more elements to the field
			int numberOfEntitiesToAdd = numberOfEntities - subEntities.size();

			for (int i = 0; i < numberOfEntitiesToAdd; i++) {
				createToEnd();
			}

		} else if (subEntities.size() > numberOfEntities) {
			// Less elements in the field - remove some last fields
			int numberOfEntitiesToRemove = subEntities.size() - numberOfEntities;

			removeAllFromIndex(numberOfEntitiesToRemove);
		}
	}

	/**
	 * TODO: doc it
	 * 
	 * @throws QuestionListException
	 */
	@SuppressWarnings("unchecked")
	private void createToEnd() throws QuestionListException {
		if (entitiesClass == null) {

			// TODO: tohle zpusobuje warning - existuje lepsi reseni??
			entitiesClass = (Class<? extends T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}

		if (!entitiesClass.isInterface()) {
			try {
				T instance = (T) entitiesClass.newInstance();
				subEntities.add(instance);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * TODO: doc it
	 * 
	 * @param numberEntitesToRemove
	 */
	private void removeAllFromIndex(int numberEntitesToRemove) {

		if (0 < numberEntitesToRemove || numberEntitesToRemove >= (subEntities.size() - 1)) {
			for (int i = 0; i < numberEntitesToRemove; i++) {
				subEntities.remove(subEntities.size() - 1);
			}
		}
	}
	
	/**
	 * TODO: doc it
	 */
	@Override
	public int countSubEntities() {
		int totalCount = subEntities.size();
		
		for (T entity : subEntities) {
			totalCount += entity.countSubEntities();
		}
		
		return totalCount;
	}
	
	public int countCompletedFields() {
		int countFields = 0;
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		BeanDescriptor constraintViolations = validator.getConstraintsForClass(this.getClass());
		for (PropertyDescriptor property : constraintViolations.getConstrainedProperties()) {
			System.out.println("Property name: " + property.getPropertyName());
		}

		for (T entity : subEntities) {
			countFields += entity.countCompletedFields();
		}
		
		return countFields;
	}
}
