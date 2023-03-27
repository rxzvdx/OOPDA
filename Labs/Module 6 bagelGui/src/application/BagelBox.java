package application;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * This will be a VBox that contains a TitledPane which contains
 * another VBox that holds radio buttons for bagels
 * 
 * @author Jack
 *
 */
public class BagelBox extends VBox {
	// The following constants are used to indicate
	// the cost of each type of bagel.
	public final double WHITE_BAGEL = 1.25;
	public final double WHEAT_BAGEL = 1.50;

	// The following variables will reference radio
	// buttons for white and whole wheat bagels.
	private RadioButton rdoWhite;
	private RadioButton rdoWheat;
	

	// The following variable will reference a
	// ToggleGroup object to group the radio buttons.
	private ToggleGroup tg;

	/**
	 *  Constructor
	 */
	public BagelBox()  {

		// Create group for the radio buttons.
		tg = new ToggleGroup();

		// Create the radio buttons.
		rdoWhite = new RadioButton("White");
		rdoWheat = new RadioButton("Wheat");

		rdoWhite.setToggleGroup(tg);
		rdoWheat.setToggleGroup(tg);
		rdoWhite.setSelected(true);

		// Make another VBox to hold the radio buttons.
		VBox vbox = new VBox(10);  // with 10 pixel spacing
		vbox.setStyle("-fx-background-color: BlanchedAlmond;");
		this.setStyle("-fx-background-color: BlanchedAlmond;");  // so outer VBox same color
		vbox.getChildren().add(rdoWhite);
		vbox.getChildren().add(rdoWheat);

		// Make a TitledPane to hold the VBox of radio buttons
		TitledPane tp = new TitledPane("Bagel", vbox);
		tp.setCollapsible(false);
		this.getChildren().add(tp); // add the titled pane to this VBox
	}

	/**
	 *  The getBagelCost method returns the cost of
	 *  the selected bagel.
	 */
	public double getBagelCost()
	{
		// The following variable will hold the cost
		// of the selected bagel.
		double bagelCost = 0.0;

		// Determine which bagel is selected.
		if (rdoWhite.isSelected())
			bagelCost = WHITE_BAGEL;
		else
			bagelCost = WHEAT_BAGEL;

		// Return the cost of the selected bagel.
		return bagelCost;
	}
}
