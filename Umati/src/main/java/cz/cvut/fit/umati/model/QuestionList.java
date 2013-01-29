package cz.cvut.fit.umati.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author davy
 * 
 */
public class QuestionList {
	/**
	 * TODO: doc it
	 */
	private final IQuestion root;

	/**
	 * TODO: doc it
	 */
	private final List<IQuestion> helperList;

	/**
	 * TODO: doc it
	 */
	private int helperIndex;

	/*
	 * Constructor
	 */
	public QuestionList(IQuestion root) {
		this.root = root;
		this.helperList = new ArrayList<IQuestion>();

		// Built helper array
		rebuildHelperList();
	}

	/*
	 * Business Methods - Writers
	 */

	/**
	 * TODO: doc it
	 */
	public void rebuildHelperList() {
		// First, clean everything
		helperList.clear();

		// Then breath-first traversal
		traverse(root);
	}

	/*
	 * Business Methods - Readers
	 */

	/**
	 * TODO: doc it
	 */
	public boolean hasNext() {
		if ((helperList.size() - 1) >= (helperIndex + 1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * TODO: doc it
	 */
	public boolean hasPrev() {
		if ((helperIndex - 1) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * TODO: doc it
	 */
	public IQuestion getActual() {
		return helperList.get(helperIndex);
	}

	/**
	 * TODO: doc it
	 */
	public int getActualIndex() {
		return helperIndex;
	}

	/**
	 * TODO: doc it
	 * 
	 * @return
	 */
	public int getActualSize() {
		return helperList.size();
	}

	/*
	 * Business Methods - Directors
	 */

	/**
	 * TODO: doc it
	 */
	public void toFirst() {
		helperIndex = 0;
	}

	/**
	 * TODO: doc it
	 */
	public void toLast() {
		helperIndex = helperList.size() - 1;
	}

	/**
	 * TODO: doc it
	 */
	public void toNext() throws QuestionListException {
		if (hasNext()) {
			helperIndex++;
		} else {
			throw new QuestionListException("Question queue has no next element");
		}
	}

	/**
	 * TODO: doc it
	 */
	public void toPrev() throws QuestionListException {
		if (hasPrev()) {
			helperIndex--;
		} else {
			throw new QuestionListException("Question queue has no previous element");
		}
	}

	/*
	 * Private methods
	 */

	/**
	 * TODO: doc it
	 * 
	 * @param entity
	 */
	private void traverse(IQuestion entity) {
		addToHelperList(entity);

		if (entity instanceof AbstractQuestion) {
			@SuppressWarnings("unchecked")
			AbstractQuestion<IQuestion> question = (AbstractQuestion<IQuestion>) entity;

			for (IQuestion q : question.subEntities()) {
				traverse(q);
			}
		}
	}

	/**
	 * Check for uniqueness when adding to the helperList
	 * 
	 * @param entity
	 */
	private void addToHelperList(IQuestion entity) {
		if (!helperList.contains(entity)) {
			helperList.add(entity);
		} else {
			throw new RuntimeException("Entities in helperList are not unique. Probably bug in the code!");
		}
	}
}
