package view;
	
import java.util.Stack;

import javafx.application.Application;

import model.CalculatorModel;

import javafx.geometry.Insets;
import javafx.stage.Stage;
import model.CalculatorModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class JavaFx extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			Stack<Double> calculatrice = new Stack<>();
			Stack<String> accu = new Stack<>();
			
			CalculatorModel calculatorModel = new CalculatorModel(calculatrice, accu);
			Buttons buttons = new Buttons(new TextField(), new TextField(), new TextField(), new TextField(), calculatrice, accu, calculatorModel); 
			GridPane buttonGrid = buttons.createButtonGrid();
			root.setBottom(buttonGrid);
		        
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Ma Calculette");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
