public class Solution {
	boolean isPalindromeString(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "abccbae";
		if (solution.isPalindromeString(s)) {
			System.out.println("It is a Palindrome String");
		} else {
			System.out.println("It is not a palindromic");
		}
	}
}
