package cz.cvut.fit.umati.ui.composite;

import java.util.Arrays;

import com.hp.hpl.jena.rdf.model.Resource;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

import cz.cvut.fit.umati.DBpediaUtil;
import cz.cvut.fit.umati.constants.XmlDataType;

@org.springframework.stereotype.Component
@org.springframework.context.annotation.Scope("session")
public class ParameterQueryQuestion extends CustomComponent {
	@AutoGenerated
	private GridLayout mainLayout;

	@AutoGenerated
	private ComboBox semanticProperty;

	@AutoGenerated
	private Label semanticPropertyLabel;

	@AutoGenerated
	private ComboBox semanticClass;

	@AutoGenerated
	private Label semanticClassLabel;

	@AutoGenerated
	private ComboBox parameterType;

	@AutoGenerated
	private Label parameterTypeLabel;

	@AutoGenerated
	private TextField parameterField;

	@AutoGenerated
	private Label parameterLabel;

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
	public ParameterQueryQuestion() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		// Parameter Type
		final BeanItemContainer<XmlDataType> xmlDataTypeContainer = new BeanItemContainer<XmlDataType>(XmlDataType.class);
		xmlDataTypeContainer.addAll(Arrays.asList(XmlDataType.values()));
		parameterType.setContainerDataSource(xmlDataTypeContainer);

		// Semantic Property
		final BeanItemContainer<Resource> semanticPropertyContainer = new BeanItemContainer<Resource>(Resource.class);
		semanticProperty.setContainerDataSource(semanticPropertyContainer);
		semanticProperty.setItemCaptionMode(ComboBox.ITEM_CAPTION_MODE_PROPERTY);
		semanticProperty.setItemCaptionPropertyId("localName");
		
		// Semantic Class
		final BeanItemContainer<Resource> semanticClassContainer = new BeanItemContainer<Resource>(Resource.class);
		semanticClassContainer.addAll(DBpediaUtil.getAllClasses());
		semanticClass.setContainerDataSource(semanticClassContainer);
		semanticClass.setItemCaptionMode(ComboBox.ITEM_CAPTION_MODE_PROPERTY);
		semanticClass.setItemCaptionPropertyId("localName");
		semanticClass.setImmediate(true);
		semanticClass.addListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (semanticClass.getValue() instanceof Resource) {
					Resource resource = (Resource) semanticClass.getValue();
					
					semanticPropertyContainer.removeAllItems();
					semanticPropertyContainer.addAll(DBpediaUtil.getAllProperties(resource.getURI()));
				}
			}
		});
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
		mainLayout.setRows(4);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// parameterLabel
		parameterLabel = new Label();
		parameterLabel.setImmediate(false);
		parameterLabel.setWidth("-1px");
		parameterLabel.setHeight("-1px");
		parameterLabel.setValue("Parameter");
		mainLayout.addComponent(parameterLabel, 0, 0);
		mainLayout.setComponentAlignment(parameterLabel, new Alignment(6));
		
		// parameterField
		parameterField = new TextField();
		parameterField.setImmediate(false);
		parameterField.setNullRepresentation("");
		parameterField.setRequired(true);
		parameterField.setRequiredError("Parameter must be filled");
		parameterField.setWidth("-1px");
		parameterField.setHeight("-1px");
		mainLayout.addComponent(parameterField, 1, 0);
		
		// parameterTypeLabel
		parameterTypeLabel = new Label();
		parameterTypeLabel.setImmediate(false);
		parameterTypeLabel.setWidth("-1px");
		parameterTypeLabel.setHeight("-1px");
		parameterTypeLabel.setValue("Parameter Type");
		mainLayout.addComponent(parameterTypeLabel, 0, 1);
		mainLayout.setComponentAlignment(parameterTypeLabel, new Alignment(6));
		
		// parameterType
		parameterType = new ComboBox();
		parameterType.setImmediate(false);
		parameterType.setWidth("-1px");
		parameterType.setHeight("-1px");
		mainLayout.addComponent(parameterType, 1, 1);
		
		// semanticClassLabel
		semanticClassLabel = new Label();
		semanticClassLabel.setImmediate(false);
		semanticClassLabel.setWidth("-1px");
		semanticClassLabel.setHeight("-1px");
		semanticClassLabel.setValue("Semantic Class");
		mainLayout.addComponent(semanticClassLabel, 0, 2);
		mainLayout.setComponentAlignment(semanticClassLabel, new Alignment(6));
		
		// semanticClass
		semanticClass = new ComboBox();
		semanticClass.setImmediate(false);
		semanticClass.setWidth("-1px");
		semanticClass.setHeight("-1px");
		mainLayout.addComponent(semanticClass, 1, 2);
		
		// semanticPropertyLabel
		semanticPropertyLabel = new Label();
		semanticPropertyLabel.setImmediate(false);
		semanticPropertyLabel.setWidth("-1px");
		semanticPropertyLabel.setHeight("-1px");
		semanticPropertyLabel.setValue("Semantic Property");
		mainLayout.addComponent(semanticPropertyLabel, 0, 3);
		mainLayout.setComponentAlignment(semanticPropertyLabel, new Alignment(6));
		
		// semanticProperty
		semanticProperty = new ComboBox();
		semanticProperty.setImmediate(false);
		semanticProperty.setWidth("-1px");
		semanticProperty.setHeight("-1px");
		mainLayout.addComponent(semanticProperty, 1, 3);
		
		return mainLayout;
	}
}
