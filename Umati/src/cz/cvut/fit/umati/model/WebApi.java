package cz.cvut.fit.umati.model;

import java.net.URI;
import java.util.List;

public class WebApi {
	private String name;
	
	private String description;
	
	private URI apiUrl;
	
	private URI docUrl;
		
	private List<WebApiElaborated> webApiElaboratedList;

	/*
	 * Getters & Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public URI getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(URI apiUrl) {
		this.apiUrl = apiUrl;
	}

	public URI getDocUrl() {
		return docUrl;
	}

	public void setDocUrl(URI docUrl) {
		this.docUrl = docUrl;
	}

	public List<WebApiElaborated> getWebApiElaboratedList() {
		return webApiElaboratedList;
	}

	public void setWebApiElaboratedList(List<WebApiElaborated> webApiElaboratedList) {
		this.webApiElaboratedList = webApiElaboratedList;
	} 
}
