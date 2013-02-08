package cz.cvut.fit.umati.model;

import java.net.URI;

public class EndPointPath extends AbstractQuestion<ParameterQuery> implements IEndPoint {
	/**
	 * TODO: doc it
	 */
	public static final String description = "Parameters are specified by METHOD and PATH part of URL";

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

	public URI getEndPointUrl() {
		return endPointUrl;
	}

	public void setEndPointUrl(URI endPointUrl) {
		this.endPointUrl = endPointUrl;
	}
}
