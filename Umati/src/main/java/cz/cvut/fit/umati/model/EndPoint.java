package cz.cvut.fit.umati.model;

import java.util.Set;

public class EndPoint {
	private int parameterNumber;
	
	private Set<Parameter> parameterSet;

	/*
	 * Getters & Setters
	 */
	public int getParameterNumber() {
		return parameterNumber;
	}

	public void setParameterNumber(int parameterNumber) {
		this.parameterNumber = parameterNumber;
	}

	public Set<Parameter> getParameterSet() {
		return parameterSet;
	}

	public void setParameterSet(Set<Parameter> parameterSet) {
		this.parameterSet = parameterSet;
	}
}
