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
	
	static TextField resultat = new TextField();

	
	/**
	 * 
	 * @param label
	 * @return
	 */
	public static Button makeButton(String label) {
	    Button button = new Button(label);
	    button.setMinSize(90, 40);
        button.setOnAction(event -> handleButtonClick(label));
	    return button;
	}
	
	/**
	 * 
	 * @return
	 */
	 public static GridPane createButtonGrid() {
		  
	        GridPane grid = new GridPane();
	        grid.setPadding(new Insets(10));
			grid.setHgap(5);
		    grid.setVgap(5);
		    

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

		        colonne++;
		        if (colonne > 3) {
		            colonne = 0;
		            ligne++;
		        }}
		    return grid;
		    }
	 
	 
		
	public static void handleButtonClick(String label) {
		
		if (label.equals("1")) {
			resultat.setText("1");
		} else {
			resultat.appendText(label);
		}
////	    if (label.equals("push")) {
////	        // Si l'utilisateur appuie sur "push", ajoutez le nombre saisi à la pile
////	        try {
////	            double num = Double.parseDouble(Buttons.resultat.getText()); // Utilisez la variable statique de Buttons
////	            stack.push(num); 
////	            Buttons.resultat.clear(); 
//	        } catch (NumberFormatException e) {
//	            Buttons.resultat.setText("Erreur"); 
//	        }
//	    } else if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/")) {
//	     
//	        if (stack.size() >= 2) {
//	            double num2 = stack.pop();
//	            double num1 = stack.pop();
//	            double result = 0.0;
//	            if (label.equals("+")) {
//	                result = num1 + num2;
//	            } else if (label.equals("-")) {
//	                result = num1 - num2;
//	            } else if (label.equals("*")) {
//	                result = num1 * num2;
//	            } else if (label.equals("/")) {
//	                if (num2 != 0) {
//	                    result = num1 / num2;
//	                } else {
//	                    Buttons.resultat.setText("Erreur"); // Utilisez la variable statique de Buttons
//	                    return;
//	                }
//	            }
//	            stack.push(result); // Utilisez la variable statique de Buttons
//	            Buttons.resultat.clear(); // Utilisez la variable statique de Buttons
//	            Buttons.resultat.setText(Double.toString(result)); // Utilisez la variable statique de Buttons
//	        } else {
//	            Buttons.resultat.setText("Erreur"); // Utilisez la variable statique de Buttons
//	        }
//	    } else {
//	        // Si l'utilisateur appuie sur un chiffre ou un point, ajoutez-le au champ de texte
//	        Buttons.resultat.appendText(label); // Utilisez la variable statique de Buttons
//	    }
	}
}