import java.util.*;

public class Solution {
	String rotateStringOnce(String s) {
		char[] str = s.toCharArray();

		// rotate
		char leftMostChar = str[0];
		for (int i = 0; i < str.length - 1; i++) {
			str[i] = str[i + 1];
		}
		str[str.length - 1] = leftMostChar;

		return String.valueOf(str);
	}

	public boolean rotateString(String s, String goal) {
		int length = s.length();
		String rotatedString = rotateStringOnce(s);
		for (int i = 0; i < length; i++) {
			System.out.println(rotatedString);
			if (rotatedString.equals(goal)) {
				return true;
			}
			rotatedString = rotateStringOnce(rotatedString);

		}
		return false;
	}
}