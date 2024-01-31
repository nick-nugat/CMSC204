public class LengthException extends Exception {
	private static final String MESSAGE = "The password must be at least 6 characters long";

	public LengthException(){
		super(MESSAGE);
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
