package cz.cvut.fit.umati;

import java.util.Set;

import cz.cvut.fit.umati.model.User;
import cz.cvut.fit.umati.model.WebApi;

public class InMemoryData {
	private Set<User> userSet;
	
	private Set<WebApi> webApiGroupSet;

	/*
	 * Getters & Setters
	 */
	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	public Set<WebApi> getWebApiGroupSet() {
		return webApiGroupSet;
	}

	public void setWebApiGroupSet(Set<WebApi> webApiGroupSet) {
		this.webApiGroupSet = webApiGroupSet;
	}	
}
