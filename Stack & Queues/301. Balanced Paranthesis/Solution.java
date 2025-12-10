public class Solution {
	boolean validPair(char exp1, char exp2) {
		return (exp1 == '(' && exp2 == ')') || (exp1 == '{' && exp2 == '}') || (exp1 == '[' && exp2 == ']');
	};

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char exp = s.charAt(i);
			if (exp == '(' || exp == '{' || exp == '[') {
				stack.push(exp);
			} else {
				if (stack.empty()) {
					return false;
				}
				char top = stack.peek();
				stack.pop();

				if (!validPair(top, exp)) {
					return false;
				}
			}
		}
		if (!stack.empty()) {
			return false;
		}
		return true;
	}
}