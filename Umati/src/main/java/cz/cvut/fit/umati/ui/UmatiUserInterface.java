package cz.cvut.fit.umati.ui;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;

import com.vaadin.Application;
import com.vaadin.ui.Window;

import cz.cvut.fit.umati.ui.composite.MainTable;

@org.springframework.stereotype.Component
@Scope("session")
public class UmatiUserInterface extends Application {
	private static final long serialVersionUID = 2L;

	private MainTable mainTable;

	@Override
	public void init() {
		/*
		 * Main Window - always first
		 */
		final Window mainWindow = new Window("Feed Filter");
		mainWindow.setSizeFull();
		mainWindow.getContent().setSizeFull();
		setMainWindow(mainWindow);

		/*
		 * Add main table
		 */
		mainTable = new MainTable();
		mainWindow.addComponent(mainTable);
	}
	
	@PreDestroy
	public void destroy() {
	}
}
