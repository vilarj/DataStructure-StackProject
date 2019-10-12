package classes;
import java.util.EmptyStackException;
public class PostfixToInfix<T> {
	public static String convert(String postfix) {
		int len = postfix.length();
		char nextCharacter;
		ArrayStack <String> valueStack = new ArrayStack <>();
		String op1, op2;
		String infix = "";
		
		for (int i = 0; i < len; i++) {
			nextCharacter = postfix.charAt(i);
			if (Character.isWhitespace(nextCharacter)) {
				continue;
			}
			else if (Character.isLetterOrDigit(nextCharacter)) {
				valueStack.push (""+nextCharacter);	
			}
			else {
				// the symbol is an operator
				if (valueStack.isEmpty()) {
					throw new EmptyStackException();
				}
				
				op1 = valueStack.pop();
				if (valueStack.isEmpty()) {
					throw new IllegalArgumentException();
				}
				
				op2 = valueStack.pop();
				
				infix = "(" + op2 + nextCharacter + op1 + ")";
				valueStack.push (infix);
			}
		}
		
		infix = valueStack.pop();
		
		if (!valueStack.isEmpty()) {
			throw new IllegalStateException();
		}
		
		infix = removeParentheses(infix);
		return infix;
	}
	
	public static String removeParentheses(String infix) {
		String infix_without_parentheses = "";
		if(infix.charAt(0) == '(' && infix.charAt(infix.length()-1) == ')') {
			infix_without_parentheses = infix.substring(1, infix.length()-1);
		}
		return infix_without_parentheses;
	}
}
