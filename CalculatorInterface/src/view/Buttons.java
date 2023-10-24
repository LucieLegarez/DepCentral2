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
		            resultat3.appendText(Double.toString(oppositeval));
		        } else if (!resultat2.getText().isEmpty()) {
		            resultat2.clear();
		            resultat2.appendText(Double.toString(oppositeval));
		        } else if (!resultat1.getText().isEmpty()) {
		             resultat1.clear();
		             resultat1.appendText(Double.toString(oppositeval));
		        } else if (!resultat.getText().isEmpty()) {
		             resultat.clear();
		             resultat.appendText(Double.toString(oppositeval));
		        }
		} else if (label.equals("drop")) {
			calculatorModel.drop(); 
	        if (!resultat3.getText().isEmpty()) {
	        	resultat3.clear();
	        } else if (!resultat2.getText().isEmpty()) {
	            resultat2.clear();
	        } else if (!resultat1.getText().isEmpty()) {
	             resultat1.clear();
	        } else if (!resultat.getText().isEmpty()) {
	             resultat.clear();
	        }
		} else if (label.equals("clear")) {
			calculatorModel.clear();
			resultat.clear();
			resultat1.clear();
			resultat2.clear();
			resultat3.clear();
		} else if (label.equals("swap")) {
			calculatorModel.swap();
			if (!resultat3.getText().isEmpty()) {
	        	String a = resultat2.getText();
	        	String b = resultat3.getText();
	        	resultat3.clear();
	        	resultat2.clear();
	        	resultat3.appendText(a);
	        	resultat2.appendText(b);
	        } else if (!resultat2.getText().isEmpty()) {
	        	String a = resultat2.getText();
	        	String b = resultat1.getText();
	        	resultat1.clear();
	        	resultat2.clear();
	        	resultat1.appendText(a);
	        	resultat2.appendText(b);
	        } else {
	        	String a = resultat.getText();
	        	String b = resultat1.getText();
	        	resultat1.clear();
	        	resultat.clear();
	        	resultat1.appendText(a);
	        	resultat.appendText(b);
	        }
//		} else if (label.equals("+")) {
//			calculatorModel.add();
//			double addval = calculatorModel.getCalculatrice().peek();
//	        if (!resultat3.getText().isEmpty()) {
//	        	resultat3.clear();
//	        	resultat2.clear();
//	        	resultat2.appendText(Double.toString(addval));
//	        } else if (!resultat2.getText().isEmpty()) {
//	            resultat2.clear();
//	            resultat1.clear();
//	            resultat1.appendText(Double.toString(addval));
//	        } else {
//	             resultat1.clear();
//	             resultat.clear();
//	             resultat.appendText(Double.toString(addval));
//	        }
//		} else if (label.equals("-")) {
//			calculatorModel.substract();
//			double subval = calculatorModel.getCalculatrice().peek();
//	        if (!resultat3.getText().isEmpty()) {
//	        	resultat3.clear();
//	        	resultat2.clear();
//	        	resultat2.appendText(Double.toString(subval));
//	        } else if (!resultat2.getText().isEmpty()) {
//	            resultat2.clear();
//	            resultat1.clear();
//	            resultat1.appendText(Double.toString(subval));
//	        } else {
//	             resultat1.clear();
//	             resultat.clear();
//	             resultat.appendText(Double.toString(subval));
//	        }
//		} else if (label.equals("*")) {
//			calculatorModel.multiply();
//			double mulval = calculatorModel.getCalculatrice().peek();
//		    if (!resultat3.getText().isEmpty()) {
//		        resultat3.clear();
//		        resultat2.clear();
//		        resultat2.appendText(Double.toString(mulval));
//		    } else if (!resultat2.getText().isEmpty()) {
//		        resultat2.clear();
//		        resultat1.clear();
//		        resultat1.appendText(Double.toString(mulval));
//		    } else {
//		        resultat1.clear();
//		        resultat.clear();
//		        resultat.appendText(Double.toString(mulval));
//		    }
//		} else if (label.equals("/")) {
//			calculatorModel.divide();
//			double divval = calculatorModel.getCalculatrice().peek();
//		    if (!resultat3.getText().isEmpty()) {
//		        resultat3.clear();
//		        resultat2.clear();
//		        resultat2.appendText(Double.toString(divval));
//		    } else if (!resultat2.getText().isEmpty()) {
//		        resultat2.clear();
//		        resultat1.clear();
//		        resultat1.appendText(Double.toString(divval));
//		    } else {
//		        resultat1.clear();
//		        resultat.clear();
//		        resultat.appendText(Double.toString(divval));
		} else if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/")) {
		    double res = calculatorModel.getCalculatrice().peek();
		    if (label.equals("+")) {
		        calculatorModel.add();
		    } else if (label.equals("-")) {
		        calculatorModel.substract();
		    } else if (label.equals("*")) {
		        calculatorModel.multiply();
		    } else if (label.equals("/")) {
		        calculatorModel.divide();
		    }
		    if (!resultat3.getText().isEmpty()) {
		        resultat3.clear();
		        resultat2.clear();
		        resultat2.appendText(Double.toString(res));
		    } else if (!resultat2.getText().isEmpty()) {
		        resultat2.clear();
		        resultat1.clear();
		        resultat1.appendText(Double.toString(res));
		    } else {
		        resultat1.clear();
		        resultat.clear();
		        resultat.appendText(Double.toString(res));
		    }}}
}