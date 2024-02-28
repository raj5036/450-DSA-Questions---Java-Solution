class Solution {
	String LCP(String s1, String s2) {
		int i = 0;
		while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
			i++;
		}
		return s1.substring(0, i);
	}

	public String longestCommonPrefix(String[] strs) { // LeetCode accepted solution
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (String str : strs) {
			prefix = LCP(str, prefix);
		}
		return prefix;
	}
}