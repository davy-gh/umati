package cz.cvut.fit.umati.model;

import java.net.URI;

import cz.cvut.fit.umati.constants.HttpMethod;
import cz.cvut.fit.umati.ui.annotations.Info;
import cz.cvut.fit.umati.ui.annotations.Map;
import cz.cvut.fit.umati.ui.annotations.View;
import cz.cvut.fit.umati.ui.composite.EndPointPathQuestion;

//TODO: prozkoumat moznost spojeni anotaciv View a Info
@View(viewClass = EndPointPathQuestion.class)
@Info(description = "Fill EndPoint Path-Type Values")
public class EndPointPath extends AbstractQuestion<ParameterPath> implements IEndPoint {
	/**
	 * TODO: doc it
	 */
	public static final String description = "Parameters are specified by METHOD and PATH part of URL";

	/**
	 * TODO: doc it
	 */
	@Map(viewField = "endPointName")
	private String endPointName;

	/**
	 * TODO: doc it
	 */
	@Map(viewField = "endPointDescription")
	private String endPointDescription;

	/**
	 * TODO: doc it
	 */
	@Map(viewField = "endPointMethod") 
	private HttpMethod httpMethod;
	
	/**
	 * TODO: doc it
	 */
	@Map(viewField = "endPointUrl")
	private URI endPointUrl;

	/*
	 * Getters & Setters
	 */
	public String getEndPointName() {
		return endPointName;
	}

	public void setEndPointName(String endPointName) {
		this.endPointName = endPointName;
	}

	public String getEndPointDescription() {
		return endPointDescription;
	}

	public void setEndPointDescription(String endPointDescription) {
		this.endPointDescription = endPointDescription;
	}

	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}

	public URI getEndPointUrl() {
		return endPointUrl;
	}

	public void setEndPointUrl(URI endPointUrl) {
		this.endPointUrl = endPointUrl;
	}
}
