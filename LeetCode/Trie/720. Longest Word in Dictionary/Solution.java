class TrieNode {
	TrieNode[] characters = new TrieNode[26];
	boolean isEndOfWord;
}

class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	void addWord(String word) {
		TrieNode node = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';

			if (node.characters[index] == null) {
				node.characters[index] = new TrieNode();
			}

			node = node.characters[index];
		}

		node.isEndOfWord = true;
	}

	boolean isValidWord(String word) {
		TrieNode node = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';

			node = node.characters[index];

			// Every prefix must itself be a complete word
			if (node == null || !node.isEndOfWord) {
				return false;
			}
		}

		return true;
	}
}

class Solution {

	public String longestWord(String[] words) {

		Trie trie = new Trie();

		for (String word : words) {
			trie.addWord(word);
		}

		String ans = "";

		for (String word : words) {

			if (trie.isValidWord(word)) {

				if (word.length() > ans.length()) {
					ans = word;
				}

				// Same length → choose lexicographically smaller
				else if (word.length() == ans.length() &&
						word.compareTo(ans) < 0) {
					ans = word;
				}
			}
		}

		return ans;
	}
}