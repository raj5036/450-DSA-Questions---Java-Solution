class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		this.left = this.right = null;
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
}

public class CreateBinaryTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		/*
		 * Following is the tree after above statement
		 * 1
		 * / \
		 * null null
		 */

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		/*
		 * 2 and 3 become left and right children of 1
		 * 1
		 * / \
		 * 2 3
		 * / \ / \
		 * null null null null
		 */
		tree.root.left.left = new Node(4);
	}
}
