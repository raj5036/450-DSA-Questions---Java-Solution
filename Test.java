import java.util.ArrayList;
import java.util.List;

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

	void leftView() {
		List<TreeNode> list = new ArrayList<>();
		leftViewUtil(root, list, 0);
	}

	void leftViewUtil(TreeNode node, List<TreeNode> list, int level) {
		if (node == null) {
			return;
		}

		if (level == list.size()) {
			System.out.print(node.data + " ");
			list.add(node);
		}

		leftViewUtil(node.left, list, level + 1);
		leftViewUtil(node.right, list, level + 1);
	}
}

public class Test {
	public static void main(String[] args) {

	}
}
