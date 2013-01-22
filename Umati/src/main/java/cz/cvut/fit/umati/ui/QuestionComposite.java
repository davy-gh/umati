package cz.cvut.fit.umati.ui;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.VerticalLayout;

public class QuestionComposite extends CustomComponent {
	private static final long serialVersionUID = 1L;

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout buttonToolbar;
	@AutoGenerated
	private Button finishButton;
	@AutoGenerated
	private Button nextButton;
	@AutoGenerated
	private Button previousButton;
	@AutoGenerated
	private Panel questionPanel;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private ProgressIndicator questionProgressIndicator;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public QuestionComposite() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// questionProgressIndicator
		questionProgressIndicator = new ProgressIndicator();
		questionProgressIndicator.setImmediate(false);
		questionProgressIndicator.setWidth("100.0%");
		questionProgressIndicator.setHeight("-1px");
		mainLayout.addComponent(questionProgressIndicator);
		
		// questionPanel
		questionPanel = buildQuestionPanel();
		mainLayout.addComponent(questionPanel);
		mainLayout.setComponentAlignment(questionPanel, new Alignment(48));
		
		// buttonToolbar
		buttonToolbar = buildButtonToolbar();
		mainLayout.addComponent(buttonToolbar);
		mainLayout.setComponentAlignment(buttonToolbar, new Alignment(24));
		
		return mainLayout;
	}

	@AutoGenerated
	private Panel buildQuestionPanel() {
		// common part: create layout
		questionPanel = new Panel();
		questionPanel.setImmediate(false);
		questionPanel.setWidth("100.0%");
		questionPanel.setHeight("100.0%");
		
		// verticalLayout_2
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("100.0%");
		verticalLayout_2.setHeight("100.0%");
		verticalLayout_2.setMargin(false);
		questionPanel.setContent(verticalLayout_2);
		
		return questionPanel;
	}

	@AutoGenerated
	private HorizontalLayout buildButtonToolbar() {
		// common part: create layout
		buttonToolbar = new HorizontalLayout();
		buttonToolbar.setImmediate(false);
		buttonToolbar.setWidth("-1px");
		buttonToolbar.setHeight("-1px");
		buttonToolbar.setMargin(false);
		
		// previousButton
		previousButton = new Button();
		previousButton.setCaption("Previous");
		previousButton.setImmediate(false);
		previousButton.setWidth("-1px");
		previousButton.setHeight("-1px");
		buttonToolbar.addComponent(previousButton);
		
		// nextButton
		nextButton = new Button();
		nextButton.setCaption("Next");
		nextButton.setImmediate(false);
		nextButton.setWidth("-1px");
		nextButton.setHeight("-1px");
		buttonToolbar.addComponent(nextButton);
		
		// finishButton
		finishButton = new Button();
		finishButton.setCaption("Finish");
		finishButton.setImmediate(false);
		finishButton.setWidth("-1px");
		finishButton.setHeight("-1px");
		buttonToolbar.addComponent(finishButton);
		
		return buttonToolbar;
	}

}