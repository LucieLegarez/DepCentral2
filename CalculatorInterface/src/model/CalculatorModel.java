package model;

import java.util.Stack;


/**
 * Cette classe permet de réaliser les calculs en "notation polonaise inverse".
 */
public class CalculatorModel implements CalculatorModelInterface{
	
	private Stack<Double> calculatrice; //création d'un attribut pile 
	private Stack<String> accu; //création d'un attribut accumulateur pour stocker les nombres
	private boolean hasPoint = false; //création d'un attribut pour écarter le cas de la double virgule
	
	
	/**
	 * Constructeur de la classe CalculatorModel qui initialise les attributs
	 * @param calculatrice
	 * @param accu
	 */
	public CalculatorModel() {
		this.calculatrice = new Stack<Double>();
		this.accu = new Stack<String>();
	}


	/**
	 * Rajoute le nombre sur l'accumulateur
	 * @param number
	 */
	public void pushAccu(String number) {
		if (hasPoint && number ==".") {
			System.out.println("Le nombre ne peut pas posséder plus d'une virgule.");
			// On ne rajoute pas la virgule et on continue à rajouter les chiffres à la suite
		} else {
			accu.push(number);
			if (accu.contains(".")) {
				hasPoint = true;
			}
		}
	}
	
	
	/**
	 * Méthode qui ajoute un nombre à la pile en le récupérant de l'accumulateur
	 * @param nombre nombre à ajouter à la pile
	 */
	public void push () {
		String concat = "";
		while (!accu.isEmpty()) {
			concat = accu.pop() + concat;
		}
		calculatrice.push(Double.parseDouble(concat));
		hasPoint = false;
	}
	
	
	/**
	 * Méthode qui permet d'enlever le dernier élément de la pile et de le renvoyer
	 */
	public void pop () {
		if (!calculatrice.isEmpty()) {
			double e = calculatrice.pop();
			System.out.println(e);
		}else {
			System.out.println("La pile est vide.");
		}
	}
	
	
	/**
	 * Méthode qui permet d'additionner entre eux les deux derniers éléments de la pile
	 */
	public void add() {
		if (calculatrice.size()>=2) {
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb1+nb2;
			calculatrice.push(resultat);
		}else {
			System.out.println("Il n'y a pas assez d'éléments pour faire une addition.");
		}
	}	
	
	
	/**
	 * Méthode qui permet de soustraire les deux derniers éléments de la pile
	 */
	public void substract() {
		if (calculatrice.size()>=2) {
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb2-nb1;
			calculatrice.push(resultat);
		}else {
			System.out.println("Il n'y a pas assez d'éléments pour faire une soustraction.");
		}
	}
	
	
	/**
	 * Méthode qui multiplie entre eux les deux derniers éléments de la pile
	 */
	public void multiply() {
		if (calculatrice.size()>=2) {
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb1*nb2;
			calculatrice.push(resultat);
		}else {
			System.out.println("Il n'y a pas assez d'éléments pour faire une multiplication.");
		}
	}
	
	
	/**
	 * Méthode qui permet de diviser entre eux les deux derniers éléments de la pile
	 */
	public void divide() {
		if (calculatrice.size()>=2 && calculatrice.get(calculatrice.size()-1)!=0) {
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb2/nb1;
			calculatrice.push(resultat);
		} else if (calculatrice.size()>=2 && calculatrice.get(calculatrice.size()-1)==0) {
			System.out.println("Erreur : division par 0.");
			calculatrice.pop(); //enlève le 0 de la pile
		} else {
			System.out.println("Il n'y a pas assez d'éléments pour faire une division.");
		}
	}
	
	
	/**
	 * Méthode qui permet de prendre l'opposé d'un nombre
	 */
	public void opposite() {
		if (!calculatrice.isEmpty()) {
			double nb = calculatrice.pop();
			double resultat = nb*(-1);
			calculatrice.push(resultat);
		}else { 
			System.out.println("La pile est vide.");
		}
	}
		
	
	/**
	 * Méthode qui permet de supprimer le dernier élément de la pile
	 */
	public void drop() {
		if (!calculatrice.isEmpty()) {
			calculatrice.pop();
		}else {
			System.out.println("La pile est vide.");
		}
	}
	
	
	/**
	 * Méthode qui permet d'échanger la position des deux derniers éléments de la pile
	 */
	public void swap() {
		if (calculatrice.size()>=2) {
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			calculatrice.push(nb1);
			calculatrice.push(nb2);
		}else {
			System.out.println("Il n'y a pas assez d'éléments pour faire l'échange.");
		}
	}
	
	/**
	 * Méthode qui vide la pile
	 */
	public void clear() {
		calculatrice.clear();
	}
	
	
	public void performOperation(String operator) {
        if (operator.equals("+")) {
            add();
        } else if (operator.equals("-")) {
            substract();
        } else if (operator.equals("*")) {
            multiply();
        } else if (operator.equals("/")) {
            divide();
        }
    }
	
	
	@Override
    public String toString(){
        if (calculatrice != null) {
            return calculatrice.toString();
        }
        return "";
    }

	
	/**
	 * Getter pour la pile correspondant à la calculatrice
	 * @return calculatrice
	 */
	public Stack<Double> getCalculatrice() {
		return calculatrice;
	}

	
	/**
	 * Setter pour la pile correspondant à la calculatrice
	 * @param calculatrice
	 */
	public void setCalculatrice(Stack<Double> calculatrice) {
		this.calculatrice = calculatrice;
	}

	
	/**
	 * Getter pour la pile correspondant à l'accumulateur
	 * @return accumulateur
	 */
	public Stack<String> getAccu() {
		return accu;
	}

	
	/**
	 * Setter pour la pile correspondant à l'accumulateur
	 * @param accumulateur
	 */
	public void setAccu(Stack<String> accu) {
		this.accu = accu;
	}
	
}
