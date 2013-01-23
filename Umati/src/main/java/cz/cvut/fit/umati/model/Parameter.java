package cz.cvut.fit.umati.model;

import java.net.URI;

import cz.cvut.fit.umati.constant.XmlDataType;

public class Parameter {
	private String parameter;
	
	private XmlDataType dataType;
	
	private URI semanticAnnotation;

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

	public URI getSemanticAnnotation() {
		return semanticAnnotation;
	}

	public void setSemanticAnnotation(URI semanticAnnotation) {
		this.semanticAnnotation = semanticAnnotation;
	}
}
