
public class CoffeeBox extends VBox {
		// The following constants are used to indicate
		// the cost of each type of coffee.
		public final double COFFEE = 1.25;
		public final double CAPPUCCINO = 2.00;
	
		// The following variables will reference radio
		// buttons for types of coffee.
		private RadioButton rdoNone;
		private RadioButton rdoRegularCoffee;
		private RadioButton rdoDecafCoffee;
		private RadioButton rdoCap;
		

		// The following variable will reference a
		// ToggleGroup object to group the radio buttons.
		private ToggleGroup tg;

		/**
		 *  Constructor
		 */
		public CoffeeBox()  {

			// Create group for the radio buttons.
			tg = new ToggleGroup();

			// Create the radio buttons.
			rdoNone = new RadioButton("None");
			rdoRegularCoffee = new RadioButton("Regular Coffee");
			rdoDecafCoffee = new RadioButton("Decaf Coffee");
			rdoCap = new RadioButton("Cappuccino");
			
			rdoDecafCoffee.setToggleGroup(tg);
			rdoRegularCoffee.setToggleGroup(tg);
			rdoCap.setToggleGroup(tg);
			rdoDecafCoffee.setSelected(true);
			

			// Make another VBox to hold the radio buttons.
			VBox vbox = new VBox(10);  // with 10 pixel spacing
			vbox.setStyle("-fx-background-color: BlanchedAlmond;");
			this.setStyle("-fx-background-color: BlanchedAlmond;");  // so outer VBox same color
			vbox.getChildren().add(rdoRegularCoffee);
			vbox.getChildren().add(rdoDecafCoffee);
			vbox.getChildren().add(rdoCap);
			
			// Make a TitledPane to hold the VBox of radio buttons
			TitledPane tp = new TitledPane("Coffee", vbox);
			tp.setCollapsible(false);
			this.getChildren().add(tp); // add the titled pane to this VBox
		}

		/**
		 *  The getCoffeeCost method returns the cost of
		 *  the selected coffee.
		 */
		public double getCoffeeCost()
		{
			// The following variable will hold the cost
			// of the selected coffee.
			double coffeeCost = 0.0;

			// Determine which coffee is selected.
			if (rdoRegularCoffee.isSelected() || rdoDecafCoffee.isSelected()) {
					coffeeCost = COFFEE;
				}
			else if(rdCap.isSelected()){
					coffeeCost = CAPPUCCINO;
				}
			else {
				coffeeCost = 0.0;
			}
			// Return the cost of the selected coffee.
			return coffeeCost;
		}
}
