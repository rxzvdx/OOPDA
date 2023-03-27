package bagelHouse;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GreetingBox extends HBox {

	private Label lblgreeting = new Label("Welcome to Della's Limited House of Bagels");
	
	public GreetingBox() {
		this.getChildren().add(lblgreeting);
		lblgreeting.setFont(new Font("Verdana", 14));
		lblgreeting.setTextFill(Color.IVORY);
		lblgreeting.setStyle("-fx-text-color: Ivory;");
		lblgreeting.setPadding(new Insets(10));
		this.setStyle("-fx-background-color: #773d22;");
		this.setAlignment(Pos.CENTER);
	}

}
