module CalculatorInterface {
	requires javafx.controls;
	
	opens view to javafx.graphics, javafx.fxml;
}
