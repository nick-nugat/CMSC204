public class QueueUnderflowException extends Exception{
	public QueueUnderflowException(){
		System.out.println("Queue is empty");
	}
}
