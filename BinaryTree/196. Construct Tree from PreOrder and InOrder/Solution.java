class TreeNode {
	char data;
	TreeNode left, right;

	TreeNode(char data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class BinaryTree {
	TreeNode root;

	BinaryTree() {
		this.root = null;
	}

	BinaryTree(char data) {
		this.root = new TreeNode(data);
	}

	/* This function is here just to test buildTree() */
	void printInOrder(TreeNode node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInOrder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInOrder(node.right);
	}

	int preOrderIndex = 0;

	TreeNode constructTree(char[] inOrder, char[] preOrder, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}

		TreeNode currentRoot = new TreeNode(preOrder[preOrderIndex]);
		preOrderIndex++; // Increment value for further recursions

		if (inStart == inEnd) {
			return currentRoot;
		}

		int inOrderRootIndex = searchNodeIndex(currentRoot, inOrder);
		currentRoot.left = constructTree(inOrder, preOrder, inStart, inOrderRootIndex - 1);
		currentRoot.right = constructTree(inOrder, preOrder, inOrderRootIndex + 1, inEnd);

		return currentRoot;
	}

	int searchNodeIndex(TreeNode node, char[] inOrder) {
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == node.data) {
				return i;
			}
		}
		return -1;
	}

}

public class Solution {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		TreeNode root = tree.constructTree(in, pre, 0, len - 1);

		System.out.println("InOrder traversal of constructed tree is : ");
		tree.printInOrder(root);
	}
}
