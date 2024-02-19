public class Notation {

//	public static MyQueue<Integer> queue = new MyQueue<>();

	public Notation(){

	}

	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		MyStack<Character> stack = new MyStack<>();
		MyQueue<String> postfix = new MyQueue<>();

		try{
			for (char value : infix.toCharArray()) {
				if (value == ' ') continue; //ignore spaces
				if (Character.isDigit(value)){
					postfix.enqueue(Character.toString(value));
				} else if (isLeftParenthesis(value)){
					stack.push(value);
				} else if (isOperator(value)){
					while (!stack.isEmpty() && precedence(stack.top()) >= precedence(value)) {
						postfix.enqueue(Character.toString(stack.pop()));
					}
					stack.push(value);
				} else if (isRightParenthesis(value)) {
					while (!stack.isEmpty() && !isLeftParenthesis(stack.top())) {
						postfix.enqueue(Character.toString(stack.pop()));
					}
					if (stack.isEmpty()) throw new InvalidNotationFormatException();
					stack.pop(); // Remove '(' from characters
				}
			}
		} catch(StackUnderflowException | StackOverflowException | QueueOverflowException e){
			throw new RuntimeException();
		}
		try {
			while (!stack.isEmpty()) {
				if (isLeftParenthesis(stack.top())) throw new InvalidNotationFormatException();
				postfix.enqueue(Character.toString(stack.pop()));
			}
		} catch(StackUnderflowException | QueueOverflowException e){
			throw new RuntimeException();
		}
		return postfix.toString();
	}


	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<>();

		try {
			for (char value : postfix.toCharArray()) {
				if (value == ' ') continue; // Ignore spaces
				if (Character.isDigit(value)) {
					stack.push(Character.toString(value)); // Push digit as a string
				} else if (isOperator(value)) {
					if (stack.size() < 2) throw new InvalidNotationFormatException();

					String operand2 = stack.pop();
					String operand1 = stack.pop();
					String subExpr = "(" + operand1 + value + operand2 + ")";

					stack.push(subExpr); // Push the combined expression back onto the characters
				}
			}

			if (stack.size() != 1) throw new InvalidNotationFormatException();
			return stack.pop(); // The final infix expression
		} catch (StackUnderflowException | StackOverflowException e) {
			throw new RuntimeException();
		}
	}



	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		MyStack<Double> stack = new MyStack<>();

		try{
			for (char value : postfixExpr.toCharArray()) {
				if (value == ' ') continue;
				if (Character.isDigit(value)){
					stack.push((double) (value - '0'));
				}  else if (isOperator(value)) {
					if (stack.size() < 2) throw new InvalidNotationFormatException();

					double right = stack.pop();
					double left = stack.pop();
					double result = applyOperation(left, right, value);

					stack.push(result);
				}
			}
			if (stack.size() != 1) throw new InvalidNotationFormatException();
			return stack.pop();
		} catch (StackUnderflowException | StackOverflowException e){
			throw new RuntimeException();
		}

	}




	// student added methods
	private static boolean isLeftParenthesis(char value){
		return value == '('
				|| value == '['
				|| value == '{'
				|| value == '<';
	}
	private static boolean isRightParenthesis(char value){
		return value == ')'
				|| value == ']'
				|| value == '}'
				|| value == '>';
	}

	private static boolean isOperator(char value) {
		return value == '+'
				|| value == '-'
				|| value == '*'
				|| value == '/';
	}

	//applies a certain operation
	private static double applyOperation(double left, double right, char operation) {
		switch(operation){
			case '+':
				return left + right;
			case '-':
				return left - right;
			case '*':
				return left * right;
			case '/':
				if (right == 0) throw new ArithmeticException("You can't divide by 0!");
				return left / right;
			default:
				throw new UnsupportedOperationException(operation + " is not an operation!");
		}
	}

	//checks for operators of higher importance
	private static int precedence(char c) {
		switch (c) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			default:
				return -1;
		}
	}
}
