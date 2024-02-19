//public class Notation {
//	public static MyStack<Character> stack = new MyStack<>();
//	public static MyQueue<Integer> queue = new MyQueue<>();
//
//	public Notation(){
//
//	}
//
//	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
//		StringBuilder postfix = new StringBuilder();
//
//		for (char value : infix.toCharArray()) {
//			if (value == ' ') continue; //ignore spaces
//			if (Character.isDigit(value)){
//				postfix.append(value);
//			} else if (isLeftParenthesis(value)){
//				stack.push(value);
//			} else if (isOperator(value)){
//				while (!stack.isEmpty() && precedence(stack.top()) >= precedence(value)) {
//					postfix.append(stack.pop());
//				}
//			} else if (isRightParenthesis(value)) {
//				while (!stack.isEmpty() && !isLeftParenthesis(stack.top())) {
//					postfix.append(stack.pop());
//				}
//				if (stack.isEmpty()) throw new InvalidNotationFormatException();
//				stack.pop(); // Remove '(' from stack
//			}
//		}
//		while (!stack.isEmpty()) {
//			if (isLeftParenthesis(stack.top())) throw new InvalidNotationFormatException();
//			postfix.append(stack.pop());
//		}
//		return postfix.toString();
//
//	}
//
//
//	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
//		StringBuilder infix = new StringBuilder();
//		for (char value : postfix.toCharArray()) {
//			if (value == ' ') continue;
//			if (Character.isDigit(value)){
//				stack.push(value);
//			} else if (isOperator(value)){
//				if (stack.size() < 2) throw new InvalidNotationFormatException();
//
//				infix.append(stack.pop());
//				infix.append(stack.pop());
//
//				infix.reverse(); //first num comes first
//
//				infix.insert(1, value); //insert operator
//
//				infix.insert(0, '('); //left parenthesis
//				infix.insert(infix.length() - 1, ')'); //right parenthesis
//
//				for (char val : infix.toString().toCharArray()) {
//					stack.push(val);
//				}
//			}
//		}
//		//todo convert these to string
//		return stack.pop();
//
//	}
//
//
//	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
//		if (stack.size() > 1) throw new InvalidNotationFormatException();
//
//	}
//
//
//
//
//	// student added methods
//	public static boolean isLeftParenthesis(char value){
//		return value == '('
//				|| value == '['
//				|| value == '{'
//				|| value == '<';
//	}
//	public static boolean isRightParenthesis(char value){
//		return value == ')'
//				|| value == ']'
//				|| value == '}'
//				|| value == '>';
//	}
//
//	public static boolean isOperator(char value) {
//		return value == '+' || value == '-' || value == '*' || value == '/';
//	}
//
//	//checks for operators of higher importance
//	public static int precedence(char c) {
//		return switch (c) {
//			case '+', '-' -> 1;
//			case '*', '/' -> 2;
//			default -> -1;
//		};
//	}
//}
