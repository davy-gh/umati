package cz.cvut.fit.umati.model;

public class User {
	private String userName;

	private int reputation;

	/*
	 * Constructor
	 */
	public User(String userName) {
		this.userName = userName;
	}

	/*
	 * Getters & Setters
	 */
	public String getUserName() {
		return userName;
	}

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
