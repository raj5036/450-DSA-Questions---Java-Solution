import java.io.*;
import java.util.*;

public class Solution {
	public List<List<String>> Anagrams(String[] words) {
		// Code here
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
}
