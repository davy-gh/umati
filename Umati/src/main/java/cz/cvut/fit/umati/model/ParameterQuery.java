package cz.cvut.fit.umati.model;

import cz.cvut.fit.umati.constants.XmlDataType;
import cz.cvut.fit.umati.ui.annotations.Info;
import cz.cvut.fit.umati.ui.annotations.Map;
import cz.cvut.fit.umati.ui.annotations.View;
import cz.cvut.fit.umati.ui.composite.ParameterQueryQuestion;

@View(viewClass = ParameterQueryQuestion.class)
@Info(description = "Fill Query Parameter Values")
public class ParameterQuery implements IQuestion {
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "parameterField")
	private String parameter;
	
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "parameterType")
	private XmlDataType dataType;
	
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "parameterAnnotation")
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
	
	@Override
	public int getNumberOfEntities() {
		return 0;
	}

	@Override
	public int getTotalCountOfSubEntities() {
		return 0;
	}
}
