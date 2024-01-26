# CMSC204 - Assignment 1 Design
> Nicholas Nguyen
___
## UML diagram
![[UML_PasswordCheckerUtility.png]]

## Pseudocode
- import necessary libraries
	- ArrayList
	- Matcher
	- Pattern
- method `comparePasswords` throws `UnmatchedException`
	- if pwd doesn't equal pwd confirm
		- throw exception
- method `comparePasswordsWithReturn`
	- returns boolean for whether first param equals second param
- method `isValidLength` throws `LengthException`
	- if pwd is less than 6
		- throw exception
- method `hasUpperAlpha` throws `NoUpperAlphaException`
	- if uppercase character exists in pwd
		- return true
	- otherwise
		- throw exception
- method `hasLowerAlpha` throws `NoLowerAlphaException`
	- if lowercase character exists in pwd
		- return true
	- otherwise
		- throw exception
- method `hasDigit`throws `NoDigitException`
	- if digit exists in pwd
		- return true
	- otherwise
		- throw exception
- method `hasSpecialChar` throws `NoSpecialCharacterException`
	- if special character exists in pwd
		- return true
	- otherwise
		- throw exception
- method `NoSameCharInSequence` throws `InvalidSequenceException`
	- if same characters are next to each other
		- throw exception
	- otherwise
		- return true
- method `isValidPassword` throws `LengthException`, `NoUpperAlphaException`,  `NoLowerAlphaException`, `NoDigitException`, `NoSpecialCharacterException`, `InvalidSequenceException`
	- if valid length, has uppercase letter, has lowercase letter, has digit, has special character, and has no same character sequences
		- return true
	- otherwise
		- one of the following exceptions will be thrown *depending on what condition(s) in the if statement throws an exception*
- method `hasBetweenSixAndNineChars`
	- if between 6 and 9 characters
		- return true
	- otherwise
		- return false
- method `isWeakPassword` throws `WeakPasswordException`
	- if between 6 to 9 characters
		- throws exception
	- otherwise
		- return false
- method `getInvalidPasswords`
	- for loop looping through ArrayList of passwords passed
		- remove valid passwords
	- return ArrayList of invalid passwords
		- format: `<pwd> <white space> <exception message>`