import java.util.Stack;

public class StackBottom {
	static void insertAtBottom(Stack<Integer> s, int x) {
		if (s.isEmpty()) {
			s.push(x);
			return;
		}

		int top = s.pop();
		insertAtBottom(s, x);
		s.push(top);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= 5; i++) {
			stack.push(i);
		}

		System.out.println(stack);
		insertAtBottom(stack, 6);
		System.out.println(stack);

		Stack
	}
}