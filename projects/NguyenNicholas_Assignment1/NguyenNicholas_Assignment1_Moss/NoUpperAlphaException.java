public class NoUpperAlphaException extends Exception {
	private static final String MESSAGE = "The password must contain at least one uppercase alphabetic character.";

	public NoUpperAlphaException() {
		super(MESSAGE);
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
