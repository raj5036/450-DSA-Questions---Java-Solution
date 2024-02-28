import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
	String expand(String s, int low, int high) {
		int length = s.length();
		while (low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
			low--;
			high++;
		}
		return s.substring(low + 1, high);
	}

	String longestPalindromeSubstring(String s, int length) {
		String cur_str = "", max_str = "";
		int cur_len = 0, max_len = 0;
		for (int i = 0; i < length; i++) {
			cur_str = expand(s, i, i);
			cur_len = cur_str.length();
			if (cur_len > max_len) {
				max_len = cur_len;
				max_str = cur_str;
			}
			cur_str = expand(s, i, i + 1);
			cur_len = cur_str.length();
			if (cur_len > max_len) {
				max_len = cur_len;
				max_str = cur_str;
			}
		}
		return max_str;
	}

	public static void main(String[] args) {

	}
}
