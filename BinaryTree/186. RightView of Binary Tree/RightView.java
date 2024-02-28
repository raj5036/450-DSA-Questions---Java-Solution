
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
	void rightView() {
		List<TreeNode> rightViewNodes = new ArrayList<>();
		int currentDepth = 0;
		this.rightViewUtil(root, currentDepth, rightViewNodes);
		for (TreeNode node : rightViewNodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();
	}

	void rightViewUtil(TreeNode node, int currentDepth, List<TreeNode> rightViewNodes) {
		if (node == null) {
			return;
		}
		if (rightViewNodes.size() == currentDepth) {
			rightViewNodes.add(node);
		}
		rightViewUtil(node.right, currentDepth + 1, rightViewNodes);
		rightViewUtil(node.left, currentDepth + 1, rightViewNodes);
	}
}

public class RightView {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(4);
		binaryTree.root.left = new TreeNode(3);
		binaryTree.root.right = new TreeNode(1);
		binaryTree.root.left.left = new TreeNode(11);
		binaryTree.root.left.right = new TreeNode(10);

		binaryTree.rightView();
	}
}
