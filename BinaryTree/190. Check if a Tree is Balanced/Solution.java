// } Driver Code Ends

//User function Template for Java

/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */

class Tree {
	int height(Node root) {
		if (root == null) {
			return 0;
		}

		int lHeight = height(root.left);
		int rHeight = height(root.right);

		return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
	}

	// Function to check whether a binary tree is balanced or not.
	// A tree is height balanced if difference between heights of left and right
	// subtrees is not more than one for all nodes of tree
	boolean isBalanced(Node root) {
		// Your code here
		if (root == null) {
			return true;
		}
		int leftSubtreeHeight = height(root.left);
		int rightSubtreeHeight = height(root.right);

		return Math.abs(leftSubtreeHeight - rightSubtreeHeight) <= 1 &&
				isBalanced(root.left) &&
				isBalanced(root.right);
	}
}
