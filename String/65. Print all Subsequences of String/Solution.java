public class Solution {
	static void printSubsequences(String s, String currentSubsequence) {
		if (s.length() == 0) {
			System.out.println(currentSubsequence);
			return;
		}
		printSubsequences(s.substring(1), currentSubsequence + s.charAt(0));
		printSubsequences(s.substring(1), currentSubsequence);
	}

	public static void main(String[] args) {
		String s = new String("RajK");
		printSubsequences(s, "");
	}
}
