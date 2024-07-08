import java.util.Stack;

public class Solution {
	static void reverseString(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}

		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result += stack.pop();
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		String s = "hello";
		reverseString(s);
	}
}
