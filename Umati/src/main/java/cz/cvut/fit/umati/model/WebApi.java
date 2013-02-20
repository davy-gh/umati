package cz.cvut.fit.umati.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class WebApi {
	/*
	 * Constants
	 */
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY = "category";
	public static final String API_URL = "apiUrl";
	public static final String DOC_URL = "docUrl";
	public static final String CORRESPONDENCE_ELEMENT_NUMBER = "correspondenceElementNumber";
	public static final String CORRESPONDENCE_TYPE_DEFINITION = "correspondenceTypeDefinition";
	public static final String CORRESPONDENCE_SEMANTIC_ANNOTATION = "correspondenceSemanticAnnotation";
	public static final String TOTAL_PROGRESS = "totalProgress";
	public static final String REFERENCE = "reference";

	/*
	 * Fields
	 */
	/**
	 * TODO: doc it
	 */
	private String name;

	/**
	 * TODO: doc it
	 */
	private String description;

	/**
	 * TODO: doc it
	 */
	private String category;

	/**
	 * TODO: doc it
	 */
	private URI apiUrl;

	/**
	 * TODO: doc it
	 */
	private URI docUrl;

	/**
	 * TODO: doc it
	 */
	private WebApiElaborated referenceWebApi;

	/**
	 * TODO: doc it
	 */
	private List<WebApiElaborated> webApiElaboratedList;

	/*
	 * Constructor
	 */
	public WebApi() {
		webApiElaboratedList = new ArrayList<WebApiElaborated>();
	}

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public WebApiElaborated getReferenceWebApi() {
		return referenceWebApi;
	}

	public void setReferenceWebApi(WebApiElaborated referenceWebApi) {
		this.referenceWebApi = referenceWebApi;
	}

	/*
	 * Business methods
	 */
	public boolean isReference() {
		if (referenceWebApi != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getCorrespondenceElementNumber() {
		int totalCount = 0;
		
		for (WebApiElaborated entity : webApiElaboratedList) {
			totalCount += entity.countSubEntities();
		}
		
		return totalCount;
	}

	public int getCorrespondenceTypeDefinition() {
		//TODO: just for parameters
		return 0;
	}

	public int getCorrespondenceSemanticAnnotation() {
		//TODO: just for parameters
		return 0;
	}

	public int getTotalProgress() {
		int totalCount = 0;
		
		for (WebApiElaborated entity : webApiElaboratedList) {
			totalCount += entity.countSubEntities();
		}
		
		return totalCount;
	}
	
	/*
	 * Private methods
	 */
	public WebApiElaborated getWebApiForUser(User user) {
		WebApiElaborated actualWebApiElaborated = null;
		
		for (WebApiElaborated webApiElaborated : getWebApiElaboratedList()) {
			if (webApiElaborated.getUser().getUserName().equals(user.getUserName())) {
				actualWebApiElaborated = webApiElaborated;
				break;
			}
		}

		if (actualWebApiElaborated == null) {
			// Create new WebApiElaborated
			try {
				actualWebApiElaborated = new WebApiElaborated();
				actualWebApiElaborated.setUser(user);
			} catch (QuestionListException e) {
				e.printStackTrace();
			}

			// Add to the list of APIs
			getWebApiElaboratedList().add(actualWebApiElaborated);
		}
		
		return actualWebApiElaborated;
	}
}
