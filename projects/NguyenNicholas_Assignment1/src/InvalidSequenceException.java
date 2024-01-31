public class InvalidSequenceException extends Exception {
	private static final String MESSAGE = "The password cannot contain more than two of the same character in sequence.";

	public InvalidSequenceException(){
		super(MESSAGE);
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
