import java.util.Scanner;

public class Solution {
	static String reverse(String s) {
		StringBuilder sb = new StringBuilder("");
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	static String reverse2(String s) {
		char[] chars = s.toCharArray();
		int n = chars.length;
		for (int i = 0; i < n / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[n - i - 1];
			chars[n - i - 1] = temp;
		}
		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.println(s);
		scanner.close();
		System.out.println("Reversed String is: " + reverse2(s));
	}
}
