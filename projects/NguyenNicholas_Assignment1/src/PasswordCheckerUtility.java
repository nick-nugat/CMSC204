import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	public PasswordCheckerUtility(){}

	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
		return password.equals(passwordConfirm);
	}

	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if (!comparePasswordsWithReturn(password, passwordConfirm))
			throw new UnmatchedException();
	}


	public static boolean isValidLength(String password) throws LengthException{
		if (password.length() < 6)
			throw new LengthException();

		return true;
	}

	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		for (int i = 0; i < password.length(); i++) {
			char current = password.charAt(i);
			if (Character.isUpperCase(current))
				return true;
		}
		throw new NoUpperAlphaException();
	}

	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for (int i = 0; i < password.length(); i++) {
			char current = password.charAt(i);
			if (Character.isLowerCase(current)) return true;
		}
		throw new NoLowerAlphaException();
	}

	public static boolean hasDigit(String password) throws NoDigitException{
		for (int i = 0; i < password.length(); i++) {
			char current = password.charAt(i);
			if (Character.isDigit(current)) return true;
		}
		throw new NoDigitException();
	}

	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches())
			throw new NoSpecialCharacterException();

		return true;
	}

	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		for (int i = 0; i < password.length(); i++)
			if (password.charAt(i) == password.charAt(i + 1))
				throw new InvalidSequenceException();

		return false;

	}

	public static boolean hasBetweenSixAndNineChars(String password){
		return (password.length() >= 6)
				&& (password.length() <= 9);
	}

	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		if (hasBetweenSixAndNineChars(password))
			throw new WeakPasswordException();
		return false;
	}

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
