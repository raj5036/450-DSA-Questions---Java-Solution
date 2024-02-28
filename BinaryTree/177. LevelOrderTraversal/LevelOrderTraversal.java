import java.util.*;

class TreeNodeDepthPair {
	TreeNode treeNode;
	int depth;

	TreeNodeDepthPair(TreeNode t, int d) {
		this.treeNode = t;
		this.depth = d;
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

	BinaryTree(int data) {
		this.root = new TreeNode(data);
	}

	BinaryTree() {
		this.root = null;
	}

	List<List<Integer>> levelOrderTraversal() {
		Queue<TreeNodeDepthPair> queue = new LinkedList<>();
		int currentDepth = 0;
		queue.add(new TreeNodeDepthPair(root, currentDepth));

		Map<Integer, List<Integer>> map = new HashMap<>();
		List<List<Integer>> answer = new ArrayList<>();

		while (!queue.isEmpty()) {
			TreeNodeDepthPair nodeDepthPair = queue.peek();
			System.out.print(nodeDepthPair.depth + ": " + nodeDepthPair.treeNode.data + " ");

			if (!map.containsKey(nodeDepthPair.depth)) {
				map.put(nodeDepthPair.depth, new ArrayList<>());
			}
			map.get(nodeDepthPair.depth).add(nodeDepthPair.treeNode.data);

			queue.remove();

			if (nodeDepthPair.treeNode.left != null)
				queue.add(new TreeNodeDepthPair(nodeDepthPair.treeNode.left, nodeDepthPair.depth + 1));
			if (nodeDepthPair.treeNode.right != null)
				queue.add(new TreeNodeDepthPair(nodeDepthPair.treeNode.right, nodeDepthPair.depth + 1));
		}

		map.forEach((k, v) -> {
			answer.add(v);
		});
		return answer;
	}
}

public class LevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(21);
		binaryTree.root.left = new TreeNode(12);
		binaryTree.root.right = new TreeNode(45);
		binaryTree.root.left.left = new TreeNode(3);
		binaryTree.root.left.right = new TreeNode(4);

		List<List<Integer>> answer = binaryTree.levelOrderTraversal();
		System.out.println(answer);
	}
}