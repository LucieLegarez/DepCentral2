package model;

import java.util.Stack;


/**
 * Cette classe permet de réaliser les calculs en "notation polonaise inverse".
 */
public class CalculatorModel implements CalculatorModelInterface{
	
	public Stack<Double> calculatrice; //création d'un attribut pile 
	public Stack<String> accu; //création d'un attribut accumulateur pour stocker les nombres
	
	
	/**
	 * Génère le constructeur
	 * @param calculatrice
	 * @param accu
	 */
	public CalculatorModel(Stack<Double> calculatrice, Stack<String> accu) {
		this.calculatrice = calculatrice;
		this.accu = accu;
	}
	
	
	/**
	 * Rajoute le nombre sur l'accumulateur
	 * @param number
	 */
	public void pushAccu(String number) {
		accu.push(number);
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
		if (calculatrice.size()>=2) {
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb2/nb1;
			calculatrice.push(resultat);
		}else {
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
	
	
	@Override
    public String toString(){
        if (calculatrice != null) {
            return calculatrice.toString();
        }
        return "";
    }


	public Stack<Double> getCalculatrice() {
		return calculatrice;
	}


	public void setCalculatrice(Stack<Double> calculatrice) {
		this.calculatrice = calculatrice;
	}


	public Stack<String> getAccu() {
		return accu;
	}


	public void setAccu(Stack<String> accu) {
		this.accu = accu;
	}
	
	

}
