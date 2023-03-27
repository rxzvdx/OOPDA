package bagelHouse;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CostBox extends HBox {

	private Label txtSub = new Label();
	private Label txtTax = new Label();
	private Label txtTotal = new Label();
	private Button btnCalc, btnExit;

	public CostBox() {

		// Set up labels for output that look like textfields
		styleOutputLabel(txtSub);
		styleOutputLabel(txtTax);
		styleOutputLabel(txtTotal);

		VBox values = new VBox(5);
		values.getChildren().add(txtSub);
		values.getChildren().add(txtTax);
		values.getChildren().add(txtTotal);

		// Set up labels
		Label lblSub = new Label("Subtotal: ");
		lblSub.setAlignment(Pos.BASELINE_RIGHT);
		Label lblTax = new Label("Tax: ");
		lblTax.setAlignment(Pos.BASELINE_RIGHT);
		Label lblTotal = new Label("Total: ");
		lblTotal.setAlignment(Pos.BASELINE_RIGHT);
		
		VBox labels = new VBox(5);
		labels.getChildren().add(lblSub);
		labels.getChildren().add(lblTax);
		labels.getChildren().add(lblTotal);
		labels.setAlignment(Pos.BASELINE_RIGHT);

		// Set up buttons
		btnCalc = new Button("Calculate");
		styleButton(btnCalc);
		btnExit = new Button("Exit");	
		styleButton(btnExit);
		btnExit.setOnAction(e -> System.exit(0));
		
		HBox buttons = new HBox(5);
		buttons.setPadding(new Insets(10));
		buttons.setAlignment(Pos.BASELINE_RIGHT);
		buttons.getChildren().add(btnCalc);
		buttons.getChildren().add(btnExit);

		// Add subboxes to this box
		this.setPadding(new Insets(20));
		this.getChildren().add(labels);
		this.getChildren().add(values);
		this.getChildren().add(buttons);
	}

	private void styleButton(Button button) {
		button.setStyle("-fx-background-color: MistyRose; -fx-border-color: Silver;");		
	}

	private void styleOutputLabel(Label label) {
		label.setMinWidth(80);	
		label.setAlignment(Pos.BASELINE_RIGHT);
		label.setStyle("-fx-border-color: LightGrey; -fx-background-color: White");
	}

	// Getters

	public Label getTxtSub() {
		return txtSub;
	}

	public Label getTxtTax() {
		return txtTax;
	}

	public Label getTxtTotal() {
		return txtTotal;
	}

	public Button getBtnCalc() {
		return btnCalc;
	}

	public void setBtnCalc(Button btnCalc) {
		this.btnCalc = btnCalc;
	}

	public Button getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(Button btnExit) {
		this.btnExit = btnExit;
	}	
	
}
