import java.util.Stack;

public class Solution { // GFG Accepted Solution
	static boolean isMatchingParenthesis(char a, char b) {
		return (a == '(' && b == ')') ||
				(a == '{' && b == '}') ||
				(a == '[' && b == ']');
	}

	static boolean isPar(String x) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < x.length(); i++) {
			char c = x.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.empty()) {
					return false;
				}
				char top = stack.peek();
				if (!isMatchingParenthesis(top, c)) {
					return false;
				}
				stack.pop();
			}
		}

		if (!stack.empty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
