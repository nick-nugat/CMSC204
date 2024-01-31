public class NoDigitException extends Exception {
	private static final String MESSAGE = "The password must contain at least one digit.";

	public NoDigitException(){
		super(MESSAGE);
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
