import java.util.*;

class TrieNode {
    TrieNode[] character = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
    }
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

            if (node.character[index] == null) {
                node.character[index] = new TrieNode();
            }

            node = node.character[index];
        }

        node.isEndOfWord = true;
    }

    void dfs(
        TrieNode node,
        String currentWord,
        List<String> suggestion
    ) {

        // LeetCode asks for max 3 suggestions
        if (suggestion.size() == 3) {
            return;
        }

        if (node.isEndOfWord) {
            suggestion.add(currentWord);
        }

        for (int i = 0; i < 26; i++) {

            if (node.character[i] != null) {

                char ch = (char) ('a' + i);

                dfs(
                    node.character[i],
                    currentWord + ch,
                    suggestion
                );

                if (suggestion.size() == 3) {
                    return;
                }
            }
        }
    }

    void getSuggestions(String search, List<String> suggestion) {

        TrieNode node = root;

        for (int i = 0; i < search.length(); i++) {

            int index = search.charAt(i) - 'a';

            if (node.character[index] == null) {
                return;
            }

            node = node.character[index];
        }

        dfs(node, search, suggestion);
    }

    void search(
        String searchWord,
        List<List<String>> suggestions
    ) {

        for (int i = 0; i < searchWord.length(); i++) {

            String prefix = searchWord.substring(0, i + 1);

            List<String> suggestion = new ArrayList<>();

            getSuggestions(prefix, suggestion);

            suggestions.add(suggestion);
        }
    }
}

class Solution {

    public List<List<String>> suggestedProducts(
        String[] products,
        String searchWord
    ) {

        Trie trie = new Trie();

        for (String product : products) {
            trie.addWord(product);
        }

        List<List<String>> suggestions = new ArrayList<>();

        trie.search(searchWord, suggestions);

        return suggestions;
    }
}