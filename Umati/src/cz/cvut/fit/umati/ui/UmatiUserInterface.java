package cz.cvut.fit.umati.ui;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;

import com.vaadin.Application;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
@Scope("session")
public class UmatiUserInterface extends Application {
	private static final long serialVersionUID = 2L;

	private TabSheet tabs;

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
		 * Add tab component
		 */
		tabs = new TabSheet();
		tabs.setSizeFull();

//		tabs.addTab(objectListManager, "Object List", icon1);
//		tabs.addTab(visualGraphManager, "Graph Visualization", icon2);

		tabs.addListener(new TabSheet.SelectedTabChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void selectedTabChange(SelectedTabChangeEvent event) {
				TabSheet tabsheet = event.getTabSheet();
				Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());
				if (tab != null) {
					mainWindow.getWindow().showNotification("Selected tab: " + tab.getCaption());
				}
			}
		});
		// mainWindow.setContent(tabs);
		mainWindow.addComponent(tabs);
	}
	
	@PreDestroy
	public void destroy() {
	}
}
