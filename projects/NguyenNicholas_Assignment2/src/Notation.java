public class Notation {
	MyStack<String> stack = new MyStack<>();
	MyQueue<Integer> queue = new MyQueue<>();

	public Notation(){

	}

	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{

	}

	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{

	}

	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		for(char value : infix.toCharArray())
			if (!(value == ' ')){
				if (Character.isDigit(value)){
					queue.enqueue(value);
				}
				if (leftParentheses(value)){
					stack.push(value);
				}
			}
	}

	//added methods
	public static boolean leftParentheses(char value){
		return value == '('
				|| value == '['
				|| value == '{'
				|| value == '<';
	}
	public static boolean rightParentheses(char value){
		return value == ')'
				|| value == ']'
				|| value == '}'
				|| value == '>';
	}
}
