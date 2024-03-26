import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static List<List<String>> Anagrams(String[] words) {
		List<List<String>> answers = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String word : words) {
			int[] key = new int[26];
			Arrays.fill(key, 0);

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				key[index]++;
			}

			// System.out.println(Arrays.toString(key));
			String wordKey = Arrays.toString(key);

			if (!map.containsKey(wordKey)) {
				map.put(wordKey, new ArrayList<>());
			}
			map.get(wordKey).add(word);
		}
		map.forEach((k, v) -> {
			List<String> answer = v;
			answers.add(answer);
		});
		return answers;
	}

	public static void main(String[] args) {
		String[] words = { "act", "god", "cat", "dog", "tac" };
		List<List<String>> answers = Anagrams(words);
		for (List<String> answer : answers) {
			for (String word : answer) {
				System.out.print(word + " ");
			}
			System.out.println();
		}
	}
}
