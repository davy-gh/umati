package cz.cvut.fit.umati.model;

import cz.cvut.fit.umati.constants.XmlDataType;
import cz.cvut.fit.umati.ui.annotations.Info;
import cz.cvut.fit.umati.ui.annotations.Map;
import cz.cvut.fit.umati.ui.annotations.View;
import cz.cvut.fit.umati.ui.composite.EndPointQueryQuestion;

@View(viewClass = EndPointQueryQuestion.class)
@Info(description = "Fill Parameter Values")
public class ParameterPath implements IQuestion {
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "")
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

	//TODO: co to tady dela, vymaz
//	MethodProperty<Integer> parameterNumberProperty = new MethodProperty<Integer>(actualEndPoint, "numberOfEntities");
//	endPointQuestion.getNumOfParamsInPath().setPropertyDataSource(parameterNumberProperty);
	
}
