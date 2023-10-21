package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import java.util.Stack;

public class Buttons{
	
	static TextField resultat;
	
	/**
	 * 
	 * @param label
	 * @return
	 */
	public static Button makeButton(String label) {
	    Button button = new Button(label);
	    button.setMinSize(90, 40);
	    return button;
	}
	
	/**
	 * 
	 * @return
	 */
	 public static GridPane createButtonGrid() {
		 
		    Buttons.resultat = resultat; 
	        GridPane grid = new GridPane();
	        grid.setPadding(new Insets(10));
			grid.setHgap(5);
		    grid.setVgap(5);
		    

		    TextField resultat = new TextField();
		    resultat.setStyle("-fx-alignment: CENTER-RIGHT;");
		    resultat.setPrefColumnCount(4);
		    resultat.setEditable(false); 
		    grid.add(resultat, 0, 0, 4, 1);
	
			String[] buttonLabels = {
					"opposite", "swap", "drop", "clear",
		            "7", "8", "9", "+",
		            "4", "5", "6", "-",
		            "1", "2", "3", "*",
		            "0", ".", "push", "/"
		        };
			
			int ligne = 5;
		    int colonne = 0;
		    
		    for (String label : buttonLabels) {
		        Button button = makeButton(label);
		        grid.add(button, colonne, ligne);
		        button.setOnAction(event -> CalculatorGUI.handleButtonClick(label));
		        colonne++;
		        if (colonne > 3) {
		            colonne = 0;
		            ligne++;
		        }}
		    return grid;
		    }
	
}