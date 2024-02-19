/**
 * @author Nicholas Nguyen
 */

public class StackOverflowException extends Exception {
	public StackOverflowException(){
		System.out.println("Stack is full");
	}
}
