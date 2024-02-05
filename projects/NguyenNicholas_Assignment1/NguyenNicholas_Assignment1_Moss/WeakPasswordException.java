public class WeakPasswordException extends Exception {
	private static final String MESSAGE = "The password is OK but weak - it contains fewer than 10 characters.";

	public WeakPasswordException(){
		super(MESSAGE);
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
