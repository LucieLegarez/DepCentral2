package model;

import java.util.Stack;

public class JavaStack {

	public static void main(String[] args) {
		Stack<Double> calculatrice = new Stack<>();
        Stack<String> accu = new Stack<>();
        CalculatorModel c = new CalculatorModel(calculatrice, accu);
        		
		c.pushAccu("1");
		c.pushAccu("3");
		c.pushAccu(".");
		c.pushAccu("2");
		System.out.println("Accu = " + c);
		c.push();
		c.pushAccu("4");
		c.push();
		c.pushAccu("5");
		c.push();
		c.multiply();
		c.clear();
		System.out.println("Pile = " + c);

	}

}
