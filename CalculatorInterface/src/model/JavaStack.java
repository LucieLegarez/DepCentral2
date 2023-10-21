package model;

import java.util.Stack;

public class JavaStack {

	public static void main(String[] args) {
		CalculatorModel c = new CalculatorModel();
		c.push(13);
		c.push(3);
		c.opposite();
		System.out.println(c);

	}

}
