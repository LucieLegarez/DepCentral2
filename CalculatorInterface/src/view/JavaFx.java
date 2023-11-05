package view;

import java.util.Stack;

import controler.CalculatorControler;
import javafx.application.Application;

import javafx.stage.Stage;
import model.CalculatorModel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class JavaFx extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			CalculatorGUI calculatorGUI = new CalculatorGUI();
			CalculatorControler calculatorControler = new CalculatorControler(calculatorGUI);
			calculatorGUI.setControler(calculatorControler);
            GridPane buttonGrid = calculatorControler.getButtonGrid();
//			calculatorGUI.setControler(calculatorControler);
			
//			GridPane buttonGrid = buttons.createButtonGrid();
			root.setBottom(buttonGrid);
		        
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Ma Calculette");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	    try {
	        launch(args);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
