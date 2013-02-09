package cz.cvut.fit.umati.model;

import cz.cvut.fit.umati.constants.ParameterType;
import cz.cvut.fit.umati.constants.XmlDataType;
import cz.cvut.fit.umati.ui.annotations.Info;
import cz.cvut.fit.umati.ui.annotations.Map;
import cz.cvut.fit.umati.ui.annotations.View;
import cz.cvut.fit.umati.ui.composite.ParameterPathQuestion;

@View(viewClass = ParameterPathQuestion.class)
@Info(description = "Fill Path Parameter Values")
public class ParameterPath implements IQuestion {
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "parameterName")
	private String parameter;
	
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "parameterType")
	private ParameterType parameterType;
	
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "parameterDataType")
	private XmlDataType dataType;
	
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "parameterAnnotation")
	private SemanticAnnotation semanticAnnotation;

	/*
	 * Getters & Setters
	 */
	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public ParameterType getParameterType() {
		return parameterType;
	}

	public void setParameterType(ParameterType parameterType) {
		this.parameterType = parameterType;
	}

	public XmlDataType getDataType() {
		return dataType;
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
