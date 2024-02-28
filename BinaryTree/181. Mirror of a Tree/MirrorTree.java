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

	void inOrderTraversal(Node node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.data + " ");
		inOrderTraversal(node.right);
	}

	Node mirrorify(Node node) {
		if (node == null) {
			return null;
		}

		Node mirror = new Node(node.data);
		mirror.left = mirrorify(node.right);
		mirror.right = mirrorify(node.left);
		return mirror;
	}
}

public class MirrorTree {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(5);
		binaryTree.root.left = new Node(3);
		binaryTree.root.right = new Node(6);
		binaryTree.root.left.left = new Node(2);
		binaryTree.root.left.right = new Node(4);

		binaryTree.inOrderTraversal(binaryTree.root);
		System.out.println();

		Node mirrorRoot = binaryTree.mirrorify(binaryTree.root);
		binaryTree.inOrderTraversal(mirrorRoot);
	}
}
