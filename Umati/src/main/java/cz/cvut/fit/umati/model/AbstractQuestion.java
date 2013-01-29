package cz.cvut.fit.umati.model;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractQuestion<T extends IQuestion> implements IQuestion {
	/**
	 * TODO: doc it
	 */
	private int numberOfEntities;

	/**
	 * TODO: doc it
	 */
	private final List<T> subEntities = new ArrayList<T>();

	/*
	 * Business methods
	 */

	/**
	 * TODO: doc it
	 * 
	 * @return
	 */
	public int getNumberOfEntities() {
		return numberOfEntities;
	}

	/**
	 * TODO: doc it
	 * 
	 * @param parameterNumber
	 */
	public void setNumberOfEntities(int numberOfEntities) {
		if (this.numberOfEntities < numberOfEntities) {
			// It's bigger = add more elements to the field
			for (int i = 0; i < numberOfEntities; i++) {
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
	 */
	private void createToEnd() {
		try {
			@SuppressWarnings("unchecked")
			T instance = (T) ((Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
			subEntities.add(instance);
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
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
