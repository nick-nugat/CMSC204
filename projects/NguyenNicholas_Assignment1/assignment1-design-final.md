# Final Assignment 1 Design
> Nicholas Nguyen
___
## GitHub screenshot
![[project-1-github-screenshot.png]]

## Learning experience
> *I'm not sure what we need to do for this section, but these are the questions I had to answer from my previous courses.*

> [!question] Write about your Learning Experience, highlighting your lessons learned and learning experience from working on this project.
> I enjoyed the learning experience I had with this project. I learned some new concepts that I now can implement into my future projects.


> [!question] What have you learned?
> This project taught me a good bit about exceptions and how to use them.


> [!question] What did you struggle with?
> I struggled with figuring out how to implement the exceptions.


> [!question] What would you do differently on your next project?
> Likely have a more consistent work schedule for projects.


> [!question] What parts of this assignment were you successful with, and what parts (if any) were you not successful with?
> I feel like I was successful with the majority of the project.


> [!question] Provide any additional resources/links/videos you used to while working on this assignment/project.
> N/A


%%
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
%%