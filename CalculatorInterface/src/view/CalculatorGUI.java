package view;

import java.util.Stack;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorGUI {
	
	static Stack<Double> stack = new Stack<Double>(); //création d'une pile vide
	
	public static void handleButtonClick(String label) {
	    if (label.equals("push")) {
	        // Si l'utilisateur appuie sur "push", ajoutez le nombre saisi à la pile
	        try {
	            double num = Double.parseDouble(Buttons.resultat.getText()); // Utilisez la variable statique de Buttons
	            stack.push(num); 
	            Buttons.resultat.clear(); 
	        } catch (NumberFormatException e) {
	            Buttons.resultat.setText("Erreur"); 
	        }
	    } else if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/")) {
	     
	        if (stack.size() >= 2) {
	            double num2 = stack.pop();
	            double num1 = stack.pop();
	            double result = 0.0;
	            if (label.equals("+")) {
	                result = num1 + num2;
	            } else if (label.equals("-")) {
	                result = num1 - num2;
	            } else if (label.equals("*")) {
	                result = num1 * num2;
	            } else if (label.equals("/")) {
	                if (num2 != 0) {
	                    result = num1 / num2;
	                } else {
	                    Buttons.resultat.setText("Erreur"); // Utilisez la variable statique de Buttons
	                    return;
	                }
	            }
	            stack.push(result); // Utilisez la variable statique de Buttons
	            Buttons.resultat.clear(); // Utilisez la variable statique de Buttons
	            Buttons.resultat.setText(Double.toString(result)); // Utilisez la variable statique de Buttons
	        } else {
	            Buttons.resultat.setText("Erreur"); // Utilisez la variable statique de Buttons
	        }
	    } else {
	        // Si l'utilisateur appuie sur un chiffre ou un point, ajoutez-le au champ de texte
	        Buttons.resultat.appendText(label); // Utilisez la variable statique de Buttons
	    }
	}

}
