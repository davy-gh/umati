package cz.cvut.fit.umati.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import cz.cvut.fit.umati.ui.annotations.Info;
import cz.cvut.fit.umati.ui.annotations.View;
import cz.cvut.fit.umati.ui.composite.EndPointQueryQuestion;

@View(viewClass = EndPointQueryQuestion.class)
@Info(description = "Fill EndPoint Query-Type Values")
public class EndPointQuery extends AbstractQuestion<ParameterQuery> implements IEndPoint {
	/**
	 * TODO: doc it
	 */
	public static final String description = "Parameters are specified by QUERY part of URL";

	/**
	 * TODO: doc it
	 */
	private String endPointName;

	/**
	 * TODO: doc it
	 */
	private String endPointDescription;

	/**
	 * TODO: doc it
	 */
	@NotBlank
	@URL
	private String endPointUrl;

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

	public String getEndPointUrl() {
		return endPointUrl;
	}

	public void setEndPointUrl(String endPointUrl) {
		this.endPointUrl = endPointUrl;
	}
}
