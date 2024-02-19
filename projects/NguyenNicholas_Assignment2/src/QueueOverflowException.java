/**
 * @author Nicholas Nguyen
 */

public class QueueOverflowException extends Exception {
	public QueueOverflowException(){
		System.out.println("Queue is full");
	}
}
