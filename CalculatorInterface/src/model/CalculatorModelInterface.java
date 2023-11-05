package model;

public interface CalculatorModelInterface {
	public void pushAccu(String number);
	public void add();
	public void substract();
	public void multiply();
	public void divide();
	public void push();
	public void pop();
	public void opposite();
	public void drop();
	public void swap();
	public void clear();
	public void performOperation(String operator);

}
