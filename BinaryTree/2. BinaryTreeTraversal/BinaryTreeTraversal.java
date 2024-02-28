class TreeNode {
	int data;
	TreeNode left, right;

	TreeNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class BinaryTree {
	TreeNode root;

	BinaryTree(int data) {
		this.root = new TreeNode(data);
	}

	BinaryTree() {
		this.root = null;
	}

	void preOrderTraversal(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.print(treeNode.data + " ");
		preOrderTraversal(treeNode.left);
		preOrderTraversal(treeNode.right);
	}

	void inOrderTraversal(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		inOrderTraversal(treeNode.left);
		System.out.print(treeNode.data + " ");
		inOrderTraversal(treeNode.right);
	}

	void postOrderTraversal(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		postOrderTraversal(treeNode.left);
		preOrderTraversal(treeNode.right);
		System.out.print(treeNode.data + " ");
	}
}

public class BinaryTreeTraversal {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(21);
		binaryTree.root.left = new TreeNode(12);
		binaryTree.root.right = new TreeNode(45);

		System.out.println("InOrder\n");
		binaryTree.inOrderTraversal(binaryTree.root);

		System.out.println("\nPreOrder\n");
		binaryTree.preOrderTraversal(binaryTree.root);

		System.out.println("\nPostOrder\n");
		binaryTree.postOrderTraversal(binaryTree.root);
	}
}
