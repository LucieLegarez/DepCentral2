package controler;

import java.util.Stack;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.CalculatorModel;
import view.Buttons;
import view.CalculatorGUI;


/**
 * Cette classe est un intermédiaire entre la vue et le modèle. 
 * Le contrôleur va recevoir les actions de "view", les traiter avec "model" et diffuser le résultat.
 */
public class CalculatorControler implements CalculatorControlerInterface{
	
	private CalculatorModel calculatorModel;
    private CalculatorGUI calculatorGUI;

    public CalculatorControler(CalculatorGUI calculatorGUI) {
    	calculatorModel = new CalculatorModel();
        this.calculatorGUI = calculatorGUI;
    }
    
    public GridPane getButtonGrid() {
        Buttons buttons = new Buttons(calculatorGUI);
        return buttons.createButtonGrid();
    }
	

	 public void handleDigitButtonClick(String digit) {
		    calculatorModel.pushAccu(digit);
		}

		public void handlePushButtonClick() {
		    if (!calculatorModel.getAccu().isEmpty()) {
		        String accuval = String.join("", calculatorModel.getAccu());
		        calculatorGUI.addResultField(accuval);
		        calculatorModel.push();
		        calculatorGUI.getScrollPane().setVvalue(1.0);
		    }
		}


		public void handleOppositeButtonClick() {
			calculatorModel.opposite();
		    if (!calculatorGUI.getResultBox().getChildren().isEmpty()) {
		    	double oppositeval = calculatorModel.getCalculatrice().peek();
		    	calculatorGUI.removeLastResultField();
		    	calculatorGUI.addResultField(Double.toString(oppositeval));
		    }
		}

		public void handleDropButtonClick() {
			calculatorModel.drop(); 
		    if (!calculatorGUI.getResultBox().getChildren().isEmpty()) {
		    	calculatorGUI.removeLastResultField();
		    }
		}

		public void handleClearButtonClick() {
		    calculatorModel.clear();
		    calculatorGUI.getResultBox().getChildren().clear();
		}

		public void handleSwapButtonClick() {
			calculatorModel.swap();
		    if (calculatorGUI.getResultBox().getChildren().size() >= 2) {
		    	int lastIndex = calculatorGUI.getResultBox().getChildren().size() - 1;
		         int last2Index = calculatorGUI.getResultBox().getChildren().size() -2;
		         TextField lastTextField = (TextField) calculatorGUI.getResultBox().getChildren().get(lastIndex);
		         TextField last2TextField = (TextField) calculatorGUI.getResultBox().getChildren().get(last2Index);
		         calculatorGUI.getResultBox().getChildren().remove(lastIndex);
		         calculatorGUI.getResultBox().getChildren().remove(last2Index);
		         calculatorGUI.getResultBox().getChildren().addAll(lastTextField, last2TextField);
		    }
		}

		public void handleOperatorButtonClick(String operator) {
		    calculatorModel.performOperation(operator);
		    if (calculatorGUI.getResultBox().getChildren().size() >= 2) {
		        double operationResult = calculatorModel.getCalculatrice().peek();
		        calculatorGUI.removeLastResultField();
		        calculatorGUI.removeLastResultField();
		        calculatorGUI.addResultField(Double.toString(operationResult));
		    }
		}
		
		


}
