class TrieNode {
	TrieNode[] characters = new TrieNode[26];
	String word;

	TrieNode() {
		for (int i = 0; i < 26; i++)
			characters[i] = null;

		word = null;
	}
}

class Trie {
	TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (node.characters[index] == null) {
				node.characters[index] = new TrieNode();
			}

			node = node.characters[index];
		}

		node.word = word;
	}
}

class Solution {
	void DFS(char[][] board, int row, int col, int R, int C, TrieNode node, String[] words, List<String> ans) {
		if (row < 0 || row == R || col < 0 || col == C)
			return;

		if (board[row][col] == '#')
			return;

		char c = board[row][col];
		int index = c - 'a';
		if (node.characters[index] == null) {
			return;
		}

		node = node.characters[index];

		if (node.word != null) {
			ans.add(node.word);

			node.word = null;
		}

		board[row][col] = '#'; // Mark as visited

		DFS(board, row - 1, col, R, C, node, words, ans);
		DFS(board, row + 1, col, R, C, node, words, ans);
		DFS(board, row, col - 1, R, C, node, words, ans);
		DFS(board, row, col + 1, R, C, node, words, ans);

		board[row][col] = c;
		return;
	}

	public List<String> findWords(char[][] board, String[] words) {
		int R = board.length;
		int C = board[0].length;

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		List<String> ans = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				DFS(board, i, j, R, C, trie.root, words, ans);
			}
		}

		return ans;
	}
}