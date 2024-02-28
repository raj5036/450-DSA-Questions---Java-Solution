import java.util.Scanner;

public class Solution {
	static String reverse(String s) {
		StringBuilder sb = new StringBuilder("");
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.println(s);
		scanner.close();
		System.out.println("Reversed String is: " + reverse(s));
	}
}
