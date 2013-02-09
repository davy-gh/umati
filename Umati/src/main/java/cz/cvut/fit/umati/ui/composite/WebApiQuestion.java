package cz.cvut.fit.umati.ui.composite;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;

import cz.cvut.fit.umati.model.EndPointPath;
import cz.cvut.fit.umati.model.EndPointQuery;
import cz.cvut.fit.umati.model.IEndPoint;

@org.springframework.stereotype.Component
@org.springframework.context.annotation.Scope("session")
public class WebApiQuestion extends CustomComponent {
	@AutoGenerated
	private GridLayout mainLayout;

	@AutoGenerated
	private TextField numericInputField;

	@AutoGenerated
	private Label numericLabel;

	@AutoGenerated
	private OptionGroup endPointsType;

	@AutoGenerated
	private Label endPointsTypeLabel;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public WebApiQuestion() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// Fill-up the container
		BeanItemContainer<Class<? extends IEndPoint>> endPointTypeContainer = new BeanItemContainer<Class<? extends IEndPoint>>(Class.class);
		endPointTypeContainer.addItem(EndPointQuery.class);
		endPointTypeContainer.addItem(EndPointPath.class);
		endPointsType.setContainerDataSource(endPointTypeContainer);
		//endPointsType.setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);

		try {
			endPointsType.setItemCaption(EndPointQuery.class, (String) EndPointQuery.class.getField("description").get(null));
			endPointsType.setItemCaption(EndPointPath.class, (String) EndPointPath.class.getField("description").get(null));
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		mainLayout.setColumns(2);
		mainLayout.setRows(2);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// endPointsTypeLabel
		endPointsTypeLabel = new Label();
		endPointsTypeLabel.setImmediate(false);
		endPointsTypeLabel.setWidth("-1px");
		endPointsTypeLabel.setHeight("-1px");
		endPointsTypeLabel.setValue("Type of EndPoints");
		mainLayout.addComponent(endPointsTypeLabel, 0, 0);
		mainLayout.setComponentAlignment(endPointsTypeLabel, new Alignment(6));
		
		// endPointsType
		endPointsType = new OptionGroup();
		endPointsType.setImmediate(false);
		endPointsType.setWidth("-1px");
		endPointsType.setHeight("-1px");
		endPointsType.setWriteThrough(false);
		mainLayout.addComponent(endPointsType, 1, 0);
		
		// numericLabel
		numericLabel = new Label();
		numericLabel.setImmediate(false);
		numericLabel.setWidth("-1px");
		numericLabel.setHeight("-1px");
		numericLabel.setValue("Number of EndPoints");
		mainLayout.addComponent(numericLabel, 0, 1);
		mainLayout.setComponentAlignment(numericLabel, new Alignment(6));
		
		// numericInputField
		numericInputField = new TextField();
		numericInputField.setImmediate(false);
		numericInputField.setWidth("-1px");
		numericInputField.setHeight("-1px");
		numericInputField.setWriteThrough(false);
		numericInputField.setNullRepresentation("0");
		mainLayout.addComponent(numericInputField, 1, 1);
		
		return mainLayout;
	}
}
