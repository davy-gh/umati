package cz.cvut.fit.umati.model;

import java.util.Set;

public class WebApiElaborated {
	private User user;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
