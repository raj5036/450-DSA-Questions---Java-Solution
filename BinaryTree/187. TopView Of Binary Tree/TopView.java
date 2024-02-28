import java.util.*;

class Pair {
	int hd; // horizontal distance
	TreeNode node;

	Pair(TreeNode node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}

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

	// https://takeuforward.org/data-structure/top-view-of-a-binary-tree/
	ArrayList<Integer> topView() {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair it = q.remove();
			int hd = it.hd;
			TreeNode temp = it.node;
			if (map.get(hd) == null)
				map.put(hd, temp.data);
			if (temp.left != null) {

				q.add(new Pair(temp.left, hd - 1));
			}
			if (temp.right != null) {

				q.add(new Pair(temp.right, hd + 1));
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		return ans;
	}
}

public class TopView {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(21);
		binaryTree.root.left = new TreeNode(1);
		binaryTree.root.right = new TreeNode(123);
		binaryTree.root.left.left = new TreeNode(19);
		binaryTree.root.left.right = new TreeNode(15);

		ArrayList<Integer> list = binaryTree.topView();
		for (int data : list) {
			System.out.print(data + " ");
		}
	}
}
