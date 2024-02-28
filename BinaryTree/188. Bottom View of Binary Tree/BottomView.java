import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
	int hd;
	TreeNode node;

	Pair(int hd, TreeNode node) {
		this.hd = hd;
		this.node = node;
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

	ArrayList<Integer> bottomView() {
		ArrayList<Integer> answer = new ArrayList<>();

		if (this.root == null) {
			return answer;
		}

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, this.root));

		Map<Integer, Integer> map = new TreeMap<>();

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int hd = pair.hd;
			TreeNode node = pair.node;

			map.put(hd, node.data);

			if (node.left != null) {
				queue.add(new Pair(hd - 1, node.left));
			}
			if (node.right != null) {
				queue.add(new Pair(hd + 1, node.right));
			}
		}

		map.forEach((k, v) -> {
			answer.add(v);
		});

		return answer;
	}
}

public class BottomView {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(20);
		binaryTree.root.left = new TreeNode(19);
		binaryTree.root.right = new TreeNode(21);
		binaryTree.root.left.left = new TreeNode(17);
		binaryTree.root.left.right = new TreeNode(18);

		ArrayList<Integer> bottomViewNodes = binaryTree.bottomView();
		for (Integer nodeData : bottomViewNodes) {
			System.out.print(nodeData + " ");
		}
	}
}
