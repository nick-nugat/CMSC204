public class UnmatchedException extends Exception {
	private static final String MESSAGE = "Passwords do not match";

	public UnmatchedException(){
		super(MESSAGE);
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}