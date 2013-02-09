package cz.cvut.fit.umati.model;

import cz.cvut.fit.umati.ui.annotations.Info;
import cz.cvut.fit.umati.ui.annotations.View;
import cz.cvut.fit.umati.ui.composite.WebApiQuestion;

@View(viewClass = WebApiQuestion.class)
@Info(description = "Fill WebApi Values")
public class WebApiElaborated extends AbstractQuestion<IEndPoint> {
	private User user;

	/**
	 * Constructor with default value - temporary
	 * 
	 * TODO: is it still necessary???
	 */
	public WebApiElaborated() {
		setSubEntitiesClass(EndPointQuery.class);
	}

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
