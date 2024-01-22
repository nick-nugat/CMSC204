import java.util.ArrayList;

public class PasswordCheckerUtility {
	public PasswordCheckerUtility(){}

	public static void comparePasswords(String password, String passwordConfirm)
			throws UnmatchedException{

	}

	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){

	}

	public static boolean isValidLength(String password)
			throws LengthException{

	}

	public static boolean hasUpperAlpha(String password)
			throws NoUpperAlphaException{

	}

	public static boolean hasLowerAlpha(String password)
			throws NoLowerAlphaException{

	}

	public static boolean hasDigit(String password)
			throws NoDigitException{

	}

	public static boolean hasSpecialChar(String password)
			throws NoSpecialCharacterException{

	}

	public static boolean NoSameCharInSequence(String password)
			throws InvalidSequenceException{

	}

	public static boolean isValidPassword(String password)
			throws LengthException, NoUpperAlphaException,
					NoLowerAlphaException, NoDigitException,
					NoSpecialCharacterException, InvalidSequenceException{

	}

	public static boolean hasBetweenSixAndNineChars(String password){

	}

	public static boolean isWeakPassword(String password)
			throws WeakPasswordException{

	}

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){

	}


}
