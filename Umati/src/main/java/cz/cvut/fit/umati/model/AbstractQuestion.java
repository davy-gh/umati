package cz.cvut.fit.umati.model;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.umati.ui.annotations.Map;
import cz.cvut.fit.umati.ui.annotations.MultipleMap;

public abstract class AbstractQuestion<T extends IQuestion> implements IQuestion {
	/**
	 * TODO: doc it
	 */
	@MultipleMap(value = { @Map(viewField = "numericInputField"), @Map(viewField = "numberOfParameters") })
	private int numberOfEntities;

	/**
	 * TODO: doc it
	 */
	@Map(viewField = "endPointsType")
	private Class<? extends T> subEntitiesClass;

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

	public Class<? extends T> getSubEntitiesClass() {
		return subEntitiesClass;
	}

	public void setSubEntitiesClass(Class<? extends T> subEntitiesClass) {
		this.subEntitiesClass = subEntitiesClass;
	}

	/*
	 * Business methods
	 */

	/**
	 * TODO: doc it
	 * 
	 * @param parameterNumber
	 * @throws QuestionListException
	 */
	public void setNumberOfEntities(int numberOfEntities) throws QuestionListException {
		// If the class is changed then clean all entities before
		if (subEntitiesClass != null && subEntities.size() > 0) {
			for (T subEntity : subEntities) {
				if (!subEntitiesClass.equals(subEntity.getClass())) {
					// Clean the queue
					subEntities.clear();
					
					// Set to zero
					this.numberOfEntities = 0;
					
					//...and break the cycle
					break;
				}
			}
		}
		
		if (this.numberOfEntities < numberOfEntities) {
			// It's bigger = add more elements to the field
			int numberOfEntitiesToAdd = numberOfEntities - this.numberOfEntities;

			for (int i = 0; i < numberOfEntitiesToAdd; i++) {
				createToEnd();
			}

		} else if (this.numberOfEntities > numberOfEntities) {
			// Less elements in the field - remove some last fields
			int numberOfEntitiesToRemove = this.numberOfEntities - numberOfEntities;

			removeAllFromIndex(numberOfEntitiesToRemove);
		}

		// Remember value
		this.numberOfEntities = numberOfEntities;
	}

	/**
	 * TODO: doc it
	 * 
	 * @return
	 */
	public List<T> subEntities() {
		return subEntities;
	}

	/*
	 * Private methods
	 */

	/**
	 * TODO: doc it
	 * 
	 * @throws QuestionListException
	 */
	@SuppressWarnings("unchecked")
	private void createToEnd() throws QuestionListException {
		if (subEntitiesClass == null) {

			// TODO: tohle zpusobuje warning - existuje lepsi reseni??
			subEntitiesClass = (Class<? extends T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}

		if (!subEntitiesClass.isInterface()) {
			try {
				T instance = (T) subEntitiesClass.newInstance();
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
}
