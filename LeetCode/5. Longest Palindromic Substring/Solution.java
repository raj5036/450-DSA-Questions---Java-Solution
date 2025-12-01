public class Solution {
	String expand(String s, int low, int high) {
		int length = s.length();
		while (low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
			low--;
			high++;
		}
		return s.substring(low + 1, high);
	}

	public String longestPalindrome(String s) {
		String max_str = "", cur_str = "";
		int max_len = 0, cur_len = 0;
		int length = s.length();

		for (int i = 0; i < length; i++) {
			cur_str = expand(s, i, i);
			cur_len = cur_str.length();
			if (cur_len > max_len) {
				max_str = cur_str;
				max_len = cur_len;
			}
			cur_str = expand(s, i, i + 1);
			cur_len = cur_str.length();
			if (cur_len > max_len) {
				max_str = cur_str;
				max_len = cur_len;
			}
		}
		return max_str;
	}
}