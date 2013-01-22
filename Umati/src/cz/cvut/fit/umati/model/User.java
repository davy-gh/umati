package cz.cvut.fit.umati.model;

public class User {
	private String userName;
	
	private int reputation;

	public String getUserName() {
		return userName;
	}

	/*
	 * Getters & Setters
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}	
}
