
// import javax.swing.text.Position.Bias;
import java.util.*;

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

	BinaryTree() {
		this.root = null;
	}

	BinaryTree(int data) {
		this.root = new TreeNode(data);
	}

	// https://takeuforward.org/data-structure/right-left-view-of-binary-tree/ [Best
	// Solution ever!]
	void leftView() {
		List<TreeNode> leftViewNodes = new ArrayList<>();
		int currentDepth = 0;
		this.leftViewUtil(this.root, currentDepth, leftViewNodes);
		for (TreeNode node : leftViewNodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();
	}

	void leftViewUtil(TreeNode node, int currentDepth, List<TreeNode> leftViewNodes) {
		if (node == null) {
			return;
		}
		if (leftViewNodes.size() == currentDepth) {
			leftViewNodes.add(node);
		}
		leftViewUtil(node.left, currentDepth + 1, leftViewNodes);
		leftViewUtil(node.right, currentDepth + 1, leftViewNodes);
	}
}

public class LeftView {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(4);
		binaryTree.root.left = new TreeNode(3);
		binaryTree.root.right = new TreeNode(1);
		binaryTree.root.left.left = new TreeNode(11);
		binaryTree.root.left.right = new TreeNode(10);

		binaryTree.leftView();
	}
}
