import java.util.HashMap;
import java.util.Map;

public class Solution {
	static void findDuplicateChars(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}

		map.forEach((k, v) -> {
			if (map.get(k) > 1) {
				System.out.println(k + "->" + v);
			}
		});
	}

	public static void main(String[] args) {
		String s = new String("GeeksForGeeks");
		findDuplicateChars(s);
	}
}
