import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		Set<Character> window = new HashSet<>();
		int left = 0; // start of current window
		int maxLen = 0;

		for (int right = 0; right < n; right++) {
			char c = s.charAt(right);

			// If current char already in window,
			// shrink from the left until it’s gone.
			while (window.contains(c)) {
				window.remove(s.charAt(left));
				left++;
			}

			// Now it's safe to add current char
			window.add(c);
			maxLen = Math.max(maxLen, right - left + 1);
		}

		return maxLen;
	}
}