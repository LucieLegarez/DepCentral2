package Main;

import java.util.Stack;


public class Calcul
{
	
	Stack<Double> calculatrice = new Stack<Double>(); //création d'une pile vide
	
	public void push (double nombre) //ajoute "nombre" à la pile
	{
		calculatrice.push(nombre);
	}
	
	public void pop () //le dernier élément de la pile est enlevé sauf si la pile est vide
	{
		if (!calculatrice.isEmpty()) 
		{
			calculatrice.pop();
		}
		else 
		{
			System.out.println("La pile est vide");
		}
	}
	
	public void add() 
	{
		if (calculatrice.size()>=2) 
		{
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb1+nb2;
			push(resultat);
		}
		else 
		{
			System.out.println("Il n'y a pas assez d'éléments pour faire une addition");
		}
	}	
		
	public void substract() 
	{
		if (calculatrice.size()>=2) 
		{
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb2-nb1;
			push(resultat);
		}
		else 
		{
			System.out.println("Il n'y a pas assez d'éléments pour faire une soustraction");
		}
	}
	
	public void multiply() 
	{
		if (calculatrice.size()>=2) 
		{
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb1*nb2;
			push(resultat);
		}
		else 
		{
			System.out.println("Il n'y a pas assez d'éléments pour faire une multiplication");
		}
	}
	
	public void divide() 
	{
		if (calculatrice.size()>=2) 
		{
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			double resultat = nb2/nb1;
			push(resultat);
		}
		else 
		{
			System.out.println("Il n'y a pas assez d'éléments pour faire une division");
		}
	}
	
	public void opposite() 
	{
		
	}
	
	public void drop() 
	{
		
	}
	
	public void swap() 
	{
		if (calculatrice.size()>=2) 
		{
			double nb1 = calculatrice.pop(); //on récupère les 2 derniers éléments de la pile
			double nb2 = calculatrice.pop();
			calculatrice.push(nb1);
			calculatrice.push(nb2);
		}
		else 
		{
			System.out.println("Il n'y a pas assez d'éléments faire l'échange");
		}
	}
	
	public void clear() 
	{
		calculatrice.clear();
	}

}
