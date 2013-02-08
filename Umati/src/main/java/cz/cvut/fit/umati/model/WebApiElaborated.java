package cz.cvut.fit.umati.model;



public class WebApiElaborated extends AbstractQuestion<IEndPoint> {
	private User user;
	
	/*
	 * Getters & Setters
	 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
