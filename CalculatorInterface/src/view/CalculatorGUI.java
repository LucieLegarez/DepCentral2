package view;

import controler.CalculatorControler;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

public class CalculatorGUI implements CalculatorGUIInterface{
	
	private VBox resultBox;
	private ScrollPane scrollPane;
	private CalculatorControler calculatorControler;
    
	public CalculatorGUI() {
		this.resultBox = new VBox();
		this.scrollPane = new ScrollPane();
		
	}
	
	public void setControler(CalculatorControler calculatorControler) {
	    this.calculatorControler = calculatorControler;
	}

	
	public void handleButtonClick(String label) {
	    if (label.matches("[0-9]") || label.equals(".")) calculatorControler.handleDigitButtonClick(label);
	    else if (label.equals("push")) calculatorControler.handlePushButtonClick();
	    else if (label.equals("opposite")) calculatorControler.handleOppositeButtonClick();
	    else if (label.equals("drop")) calculatorControler.handleDropButtonClick();
	    else if (label.equals("clear")) calculatorControler.handleClearButtonClick();
	    else if (label.equals("swap")) calculatorControler.handleSwapButtonClick();
	    else if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/"))
	    	calculatorControler.handleOperatorButtonClick(label);
	    
	}
 
	public void removeLastResultField() {
		int lastIndex = resultBox.getChildren().size() - 1;
	    resultBox.getChildren().remove(lastIndex);
	}

	public void addResultField(String value) {
	    TextField resultField = new TextField(value);
	    resultField.setStyle("-fx-alignment: CENTER-RIGHT;");
	    resultField.setPrefColumnCount(4);
	    resultField.setEditable(false);
	    resultBox.getChildren().add(resultField);
	}
	
	
	public VBox getResultBox() {
		return resultBox;
	}


	public void setResultBox(VBox resultBox) {
		this.resultBox = resultBox;
	}


	public ScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(ScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	

}
