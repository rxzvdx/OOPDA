package application;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class ToppingsBox extends VBox {
	// The following constants are used to indicate
	// the cost of each type of topping.
	public final double CREAM_CHEESE = .50;
	public final double BUTTER = .25;
	public final double JELLY_N_JAMS = .75;

	// The following variables will reference check
	// boxes for types of toppings.
	private CheckBox cbCreamCheese;
	private CheckBox cbButter;
	private CheckBox cbPeach;
	private CheckBox cbBlueberry;

	/**
	 * Constructor
	 */
	public ToppingsBox() {

		// Create the check boxes.
		cbCreamCheese = new CheckBox("Cream Cheese");
		cbButter = new CheckBox("Butter");
		cbPeach = new CheckBox("Peach Jelly");
		cbBlueberry = new CheckBox("Blueberry Jam");
		
		cbButter.setSelected(true);
		cbBlueberry.setSelected(true);

		// Make another VBox to hold the check boxes.
		VBox vbox = new VBox(10); // with 10 pixel spacing
		vbox.setStyle("-fx-background-color: OldLace;");
		this.setStyle("-fx-background-color: OldLace;"); // so outer VBox same color
		vbox.getChildren().add(cbCreamCheese);
		vbox.getChildren().add(cbButter);
		vbox.getChildren().add(cbPeach);
		vbox.getChildren().add(cbBlueberry);

		// Make a TitledPane to hold the VBox of check boxes
		TitledPane tp = new TitledPane("Toppings", vbox);
		tp.setCollapsible(false);
		this.getChildren().add(tp); // add the titled pane to this VBox
	}

	/**
		 *  The getCoffeeCost method returns the cost of
		 *  the selected coffee.
		 */
		public double getToppingsCost()
		{
			// The following variable will hold the cost
			// of the selected bagel.
			double toppingCost = 0.0;

			// Determine which topping is selected.
			if (cbCreamCheese.isSelected() ) {
				toppingCost += CREAM_CHEESE;
			}

			if(cbButter.isSelected()) {
				toppingCost += BUTTER;
			}
			
			if(cbPeach.isSelected())
			{
				toppingCost += JELLY_N_JAMS;
			}
			
			if(cbBlueberry.isSelected())
			{
				toppingCost += JELLY_N_JAMS;
			}
			// Return the cost of the selected topping.
			return toppingCost;
		}

}
