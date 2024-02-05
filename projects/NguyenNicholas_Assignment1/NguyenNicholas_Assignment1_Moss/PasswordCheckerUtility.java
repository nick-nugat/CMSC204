import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PasswordCheckerUtility class to check passwords for their security, throwing respective exceptions when needed
 * @author Nicholas Nguyen
 *
 */
public class PasswordCheckerUtility {
	public PasswordCheckerUtility(){}

	/**
	 * Compares passwords with return
	 * @param password
	 * @param passwordConfirm
	 * @return
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
		return password.equals(passwordConfirm);
	}

	/**
	 * Compares password
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if (!comparePasswordsWithReturn(password, passwordConfirm))
			throw new UnmatchedException();
	}


	/**
	 * Checks if password is less than 6
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException{
		if (password.length() < 6)
			throw new LengthException();

		return true;
	}

	/**
	 * Checks if password has uppercase letter
	 * @param password
	 * @return
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		for (int i = 0; i < password.length(); i++) {
			char current = password.charAt(i);
			if (Character.isUpperCase(current))
				return true;
		}
		throw new NoUpperAlphaException();
	}

	/**
	 * Checks if password has lowercase letter
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for (int i = 0; i < password.length(); i++) {
			char current = password.charAt(i);
			if (Character.isLowerCase(current)) return true;
		}
		throw new NoLowerAlphaException();
	}

	/**
	 * Checks if password has a digit
	 * @param password
	 * @return
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		for (int i = 0; i < password.length(); i++) {
			char current = password.charAt(i);
			if (Character.isDigit(current)) return true;
		}
		throw new NoDigitException();
	}

	/**
	 * Checks if password has a special character
	 * @param password
	 * @return
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches())
			throw new NoSpecialCharacterException();

		return true;
	}

	/**
	 * Checks if password has two or more of the same characters next to each other
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		for (int i = 0; i < password.length() - 1; i++) {
			char current = password.charAt(i);
			char next = password.charAt(i + 1);

			if (current == next)
				throw new InvalidSequenceException();
		}
		return true;

	}

	/**
	 * Checks if password has between 6 to 9 characters
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars(String password){
		return (password.length() >= 6)
				&& (password.length() <= 9);
	}

	/**
	 * If password is between 6 and 9 characters (method call), password is weak (but not invalid)
	 * @param password
	 * @return
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		if (hasBetweenSixAndNineChars(password))
			throw new WeakPasswordException();
		return false;
	}

	/**
	 * Calls all methods to determine if password is valid
	 * @param password
	 * @return
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password)
			throws LengthException,
					NoUpperAlphaException,
					NoLowerAlphaException,
					NoDigitException,
					NoSpecialCharacterException,
					InvalidSequenceException{

		return isValidLength(password)
				&& hasUpperAlpha(password)
				&& hasLowerAlpha(password)
				&& hasDigit(password)
				&& hasSpecialChar(password)
				&& NoSameCharInSequence(password);
	}

	/**
	 * Returns a String ArrayList of the invalid passwords along with their respective exception messages
	 * @param passwords
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();

		for (String password : passwords) {
			try {
				isValidPassword(password);
			} catch (LengthException e) {
				invalidPasswords.add(password + " " + e.getMessage());
			} catch (NoUpperAlphaException e) {
				invalidPasswords.add(password + " " + e.getMessage());
			} catch (NoLowerAlphaException e) {
				invalidPasswords.add(password + " " + e.getMessage());
			} catch (NoDigitException e) {
				invalidPasswords.add(password + " " + e.getMessage());
			} catch (InvalidSequenceException e) {
				invalidPasswords.add(password + " " + e.getMessage());
			} catch (NoSpecialCharacterException e) {
				invalidPasswords.add(password + " " + e.getMessage());
			}
		}
		return invalidPasswords;
	}


}
