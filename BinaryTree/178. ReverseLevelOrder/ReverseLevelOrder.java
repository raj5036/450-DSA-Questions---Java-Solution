import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class ReverseLevelOrder {
	public ArrayList<Integer> reverseLevelOrder(Node root) {
		// code here
		ArrayList<Integer> answer = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		Stack<Integer> stack = new Stack<>();

		while (!queue.isEmpty()) {
			Node node = queue.peek();
			queue.remove();

			stack.push(node.data);

			/* Enqueue right child */
			// NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
			if (node.right != null)
				queue.add(node.right);
			if (node.left != null)
				queue.add(node.left);
		}

		while (!stack.isEmpty()) {
			int data = stack.pop();
			answer.add(data);
		}
		return answer;
	}

	public static void main(String[] args) {

	}
}
