/**
 * @author Nicholas Nguyen
 */

public class StackUnderflowException extends Exception {
	public StackUnderflowException(){
		System.out.println("Stack is empty");
	}
}
