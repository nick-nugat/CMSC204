public class NoLowerAlphaException extends Exception {
	private static final String MESSAGE = "The password must contain at least one lowercase alphabetic character";

	public NoLowerAlphaException(){
		super(MESSAGE);
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
