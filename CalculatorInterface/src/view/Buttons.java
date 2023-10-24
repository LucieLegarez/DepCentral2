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

import model.CalculatorModel;

public class Buttons{
	
	public TextField resultat = new TextField();
	public TextField resultat1 = new TextField();
	public TextField resultat2 = new TextField();
	public TextField resultat3 = new TextField();
	
	Stack<Double> calculatrice = new Stack<>();
	Stack<String> accu = new Stack<>();
	
	CalculatorModel calculatorModel = new CalculatorModel(calculatrice, accu);

	

	public Buttons(TextField resultat, TextField resultat1, TextField resultat2, TextField resultat3,
			Stack<Double> calculatrice, Stack<String> accu, CalculatorModel calculatorModel) {
		super();
		this.resultat = resultat;
		this.resultat1 = resultat1;
		this.resultat2 = resultat2;
		this.resultat3 = resultat3;
		this.calculatrice = calculatrice;
		this.accu = accu;
		this.calculatorModel = calculatorModel;
	}

	/**
	 * 
	 * @param label
	 * @return
	 */
	public Button makeButton(String label) {
	    Button button = new Button(label);
	    button.setMinSize(90, 40);
        button.setOnAction(event -> handleButtonClick(label));
	    return button;
	}
	
	/**
	 * 
	 * @return
	 */
	 public GridPane createButtonGrid() {
		  
	        GridPane grid = new GridPane();
	        grid.setPadding(new Insets(10));
			grid.setHgap(5);
		    grid.setVgap(5);
		    

		    resultat.setStyle("-fx-alignment: CENTER-RIGHT;");
		    resultat.setPrefColumnCount(4);
		    resultat.setEditable(false); 
		    grid.add(resultat, 0, 3, 4, 1);
		    
		    resultat1.setStyle("-fx-alignment: CENTER-RIGHT;");
		    resultat1.setPrefColumnCount(4);
		    resultat1.setEditable(false); 
		    grid.add(resultat1, 0, 2, 4, 1);
		    
		    resultat2.setStyle("-fx-alignment: CENTER-RIGHT;");
		    resultat2.setPrefColumnCount(4);
		    resultat2.setEditable(false); 
		    grid.add(resultat2, 0, 1, 4, 1);
		    
		    resultat3.setStyle("-fx-alignment: CENTER-RIGHT;");
		    resultat3.setPrefColumnCount(4);
		    resultat3.setEditable(false); 
		    grid.add(resultat3, 0, 0, 4, 1);
	
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
	 
	 
		
	public void handleButtonClick(String label) {
		
		if (label.matches("[0-9]")) {
			calculatorModel.pushAccu(label);

		} else if (label.equals("push")){
			if (!calculatorModel.getAccu().isEmpty()) {
	            String accuval = String.join("", calculatorModel.getAccu());
	            if (!resultat.getText().isEmpty() &resultat1.getText().isEmpty()) {
	            	resultat1.appendText(accuval);
	            } else if (!resultat.getText().isEmpty() && !resultat1.getText().isEmpty() && resultat2.getText().isEmpty()) {
	            	resultat2.appendText(accuval);
	            } else if (!resultat2.getText().isEmpty() & !resultat1.getText().isEmpty() & !resultat.getText().isEmpty() & resultat3.getText().isEmpty()) {
	            	resultat3.appendText(accuval);
	            } else { 
	            	resultat.appendText(accuval);
	        }
			calculatorModel.push();
		}} else if (label.equals(".")){
			calculatorModel.pushAccu(label);
		} else if (label.equals("opposite")){
			 calculatorModel.opposite();
		     	double oppositeval = calculatorModel.getCalculatrice().peek();
		        if (!resultat3.getText().isEmpty()) {
		        	resultat3.clear();
		            resultat3.setText(Double.toString(oppositeval));
		        } else if (!resultat2.getText().isEmpty()) {
		            resultat2.clear();
		            resultat2.setText(Double.toString(oppositeval));
		        } else if (!resultat1.getText().isEmpty()) {
		             resultat1.clear();
		             resultat1.setText(Double.toString(oppositeval));
		        } else if (!resultat.getText().isEmpty()) {
		             resultat.clear();
		             resultat.setText(Double.toString(oppositeval));
		        }
//			calculatorModel.opposite();
//			resultat.clear();
//	        resultat.appendText(calculatorModel.getCalculatrice().peek().toString());
//		} else if (label.equals("+")) {
			
		}
	}
}