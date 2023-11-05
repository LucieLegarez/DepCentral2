package view;

import javafx.scene.control.Button;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class Buttons{

	
	private CalculatorGUI calculatorGUI;

	
	public Buttons(CalculatorGUI calculatorGUI) {
		this.calculatorGUI = calculatorGUI;
	}

	
	/**
	 * Méthode qui permet de créer un bouton
	 * @param label écriture sur le bouton
	 * @return bouton créé
	 */
	public Button makeButton(String label) {
	    Button button = new Button(label);
	    button.setMinSize(90, 40);
        button.setOnAction(event -> calculatorGUI.handleButtonClick(label));
	    return button;
	}
	
	
	public GridPane createButtonGrid() {
	    GridPane grid = initializeGrid();
	    ScrollPane scrollPane = createScrollPane();
	    grid.add(scrollPane, 0, 0, 4, 1);
	    createButtons(grid);
	    return grid;
	}

	public GridPane initializeGrid() {
	    GridPane grid = new GridPane();
	    grid.setPadding(new Insets(10));
	    grid.setHgap(5);
	    grid.setVgap(5);
	    VBox resultBox = calculatorGUI.getResultBox();
	    resultBox.setMaxHeight(130);
	    return grid;
	}

	public ScrollPane createScrollPane() {
	    ScrollPane scrollPane = new ScrollPane(calculatorGUI.getResultBox());
	    scrollPane.setFitToWidth(true);
	    scrollPane.setMaxHeight(130);
	    return scrollPane;
	}

	public void createButtons(GridPane grid) {
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
	        }
	    }
	}
}