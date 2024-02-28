class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
	}
}

class BinaryTree {
	Node root;

	BinaryTree(int data) {
		this.root = new Node(data);
	}

	BinaryTree() {
		this.root = null;
	}

	int getDiameter(Node node) {
		if (node == null) {
			return 0;
		}
		int leftDiameter = getDiameter(node.left);
		int rightDiameter = getDiameter(node.right);

		int leftHeight = getDiameter(node.left);
		int rightHeight = getDiameter(node.right);

		return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
	}
}
