package cz.cvut.fit.umati.model;

import cz.cvut.fit.umati.constant.XmlDataType;

public class Parameter implements IQuestion {
	/**
	 * TODO: doc it
	 */
	private String parameter;
	
	/**
	 * TODO: doc it
	 */
	private XmlDataType dataType;
	
	/**
	 * TODO: doc it
	 */
	private SemanticAnnotation semanticAnnotation;

	/*
	 * Getters & Setters
	 */
	public XmlDataType getDataType() {
		return dataType;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public void setDataType(XmlDataType dataType) {
		this.dataType = dataType;
	}

	public SemanticAnnotation getSemanticAnnotation() {
		return semanticAnnotation;
	}

	public void setSemanticAnnotation(SemanticAnnotation semanticAnnotation) {
		this.semanticAnnotation = semanticAnnotation;
	}
}
