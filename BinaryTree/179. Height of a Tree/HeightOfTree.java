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

	int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}
}
