package cz.cvut.fit.umati.model;

import com.hp.hpl.jena.rdf.model.Resource;

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
	@Map(viewField = "semanticClass")
	private Resource semanticClass;

	/**
	 * TODO: doc it
	 */
	@Map(viewField = "semanticProperty")
	private Resource semanticProperty;

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

	public Resource getSemanticClass() {
		return semanticClass;
	}

	public void setSemanticClass(Resource semanticClass) {
		this.semanticClass = semanticClass;
	}

	public Resource getSemanticProperty() {
		return semanticProperty;
	}

	public void setSemanticProperty(Resource semanticProperty) {
		this.semanticProperty = semanticProperty;
	}

	@Override
	public int countSubEntities() {
		return 0;
	}

	@Override
	public int countCompletedFields() {
		// TODO Auto-generated method stub
		return 0;
	}
}
