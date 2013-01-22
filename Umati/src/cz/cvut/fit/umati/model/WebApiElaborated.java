package cz.cvut.fit.umati.model;

import java.util.Set;

public class WebApiElaborated {
	private int endPointNumber;

	private Set<EndPoint> endPointSet;

	/*
	 * Getters & Setters
	 */
	public Set<EndPoint> getEndPointSet() {
		return endPointSet;
	}

	public void setEndPointSet(Set<EndPoint> endPointSet) {
		this.endPointSet = endPointSet;
	}

	public int getEndPointNumber() {
		return endPointNumber;
	}

	public void setEndPointNumber(int endPointNumber) {
		this.endPointNumber = endPointNumber;
	}
}
