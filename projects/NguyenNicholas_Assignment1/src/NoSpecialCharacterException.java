public class NoSpecialCharacterException extends Exception {
	private static final String MESSAGE = "The password must contain at least one special character";

	public NoSpecialCharacterException(){
		super(MESSAGE);
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
