
public class Pile {
	
	private int top;
	private int[] pile;
	
	public Pile(int capacite) {
		pile = new int[capacite];
		top = -1;
	}
	
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
		}
	
	public boolean isFull() {
		if (top == pile.length) {
			return true;
		}
		return false;
		}
	
	public void push(int element) {
		if (isFull()) {
			System.out.println("La pile est pleine")
		}
		pile[top+1]= element;
		top ++;
	}
	public int pop() {
		if (isEmpty()) {
			System.out.println("La pile est vide")
		}
		top --;
		return pile[top+1];
	}
	public void drop() {
	}
	public void swap() {
	}
	public void clear() {
	}
	}

}
