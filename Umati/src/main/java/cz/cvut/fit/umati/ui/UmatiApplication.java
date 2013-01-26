package cz.cvut.fit.umati.ui;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import cz.cvut.fit.umati.InMemoryUserData;
import cz.cvut.fit.umati.InMemoryWebApiData;
import cz.cvut.fit.umati.model.User;
import cz.cvut.fit.umati.ui.composite.MainTable;
import cz.cvut.fit.umati.ui.composite.MainToolbar;

@org.springframework.stereotype.Component
@Scope("session")
public class UmatiApplication extends Application {
	private static final long serialVersionUID = 2L;

	@Autowired
	private InMemoryWebApiData inMemoryWebApiData;

	@Autowired
	private InMemoryUserData inMemoryUserData;

	@Autowired
	private MainTable mainTable;

	@Autowired
	private MainToolbar mainToolbar;
	
	@Override
	public void init() {
		/*
		 * Add actual logged user to the userSet if he is not already
		 */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!inMemoryUserData.containsId(auth.getName())) {
			inMemoryUserData.addBean(new User(auth.getName()));
		}
		mainToolbar.getLoggedUser().setValue(auth.getName());
		mainToolbar.getLogoutLink().setResource(new ExternalResource("j_spring_security_logout"));
		
		/*
		 * Main Window - always first
		 */
		final Window mainWindow = new Window("Umati Chanzo");
		mainWindow.setSizeFull();
		mainWindow.getContent().setSizeFull();
		setMainWindow(mainWindow);

		/*
		 * Add application toolbar
		 */
		mainWindow.addComponent(mainToolbar);

		/*
		 * Add main table
		 */
		mainWindow.addComponent(mainTable);
		((VerticalLayout) mainWindow.getContent()).setExpandRatio(mainTable, 1.0f);
	}

	@PreDestroy
	public void destroy() {
	}
}
