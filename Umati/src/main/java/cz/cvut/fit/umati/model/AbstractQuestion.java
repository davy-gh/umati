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
			int index = this.numberOfEntities - numberOfEntities;
			removeAllFromIndex(index);
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
	 * @param index
	 */
	private void removeAllFromIndex(int index) {
		if (0 < index || index >= (subEntities.size() - 1)) {
			for (int i = (subEntities.size() - 1); index > i; i--) {
				subEntities.remove(i);
			}
		}
	}
}
