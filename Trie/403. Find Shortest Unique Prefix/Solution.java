// https://workat.tech/problem-solving/approach/sup/shortest-unique-prefix

public class Solution {
	public static class TrieNode {
		TrieNode[] characters = new TrieNode[26];
		int[] frequency = new int[26];
		boolean isEndOfWord;

		TrieNode() {
			for (int i = 0; i < 26; i++) {
				frequency[i] = 0;
				characters[i] = null;
			}
			isEndOfWord = false;
		}
	}

	void insert(String word, TrieNode root) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (node.characters[index] == null) {
				node.characters[index] = new TrieNode();
			}
			node.frequency[index] += 1;
			node = node.characters[index];
		}
	}

	String find(String word, TrieNode root) {
		TrieNode node = root;
		String answer = "";
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (node.frequency[index] == 1) {
				answer += word.charAt(i);
				return answer;
			} else {
				answer += word.charAt(i);
				node = node.characters[index];
			}
		}
		return answer;
	}

	String[] getShortestUniquePrefixes(String[] words) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			insert(words[i], root);
		}
		String[] answer = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			answer[i] = find(words[i], root);
		}
		return answer;
	}

	public static void main(String[] args) {
		String arr[] = { "zebra", "dog", "duck", "dove" };
		Solution solution = new Solution();
		String[] answers = solution.getShortestUniquePrefixes(arr);
		for (String answer : answers)
			System.out.print(answer + " ");
	}
}