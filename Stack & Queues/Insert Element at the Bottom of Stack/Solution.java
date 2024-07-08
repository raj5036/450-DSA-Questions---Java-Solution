import java.util.Stack;

public class Solution {
	static void insertBottom(Stack<Integer> stack, int N) {
		if (stack.isEmpty()) {
			stack.push(N);
		} else {
			int top = stack.peek();
			stack.pop();

			insertBottom(stack, N);

			stack.push(top);
		}
	}

	static void printStack(Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= 5; i++) {
			stack.push(i);
		}

		int N = 100;
		insertBottom(stack, N);
		printStack(stack);
	}
}
