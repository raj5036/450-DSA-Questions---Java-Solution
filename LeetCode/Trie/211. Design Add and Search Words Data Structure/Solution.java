class TrieNode {
	TrieNode[] characters = new TrieNode[26];
	boolean isEndOfWord;

	TrieNode() {
		isEndOfWord = false;
	}
}

class WordDictionary {

	TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';

			if (node.characters[index] == null) {
				node.characters[index] = new TrieNode();
			}

			node = node.characters[index];
		}

		// Complete word ends here
		node.isEndOfWord = true;
	}

	boolean searchUtil(String word, TrieNode node, int index) {

		// All characters processed
		if (index == word.length()) {
			return node.isEndOfWord;
		}

		char c = word.charAt(index);

		// Wildcard
		if (c == '.') {

			for (int i = 0; i < 26; i++) {

				if (node.characters[i] != null) {

					if (searchUtil(
							word,
							node.characters[i],
							index + 1)) {
						return true;
					}
				}
			}

			return false;
		}

		// Normal character
		int i = c - 'a';

		if (node.characters[i] == null) {
			return false;
		}

		return searchUtil(
				word,
				node.characters[i],
				index + 1);
	}

	public boolean search(String word) {
		return searchUtil(word, root, 0);
	}
}