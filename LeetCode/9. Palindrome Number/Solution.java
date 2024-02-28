import java.util.Scanner;

public class Solution {
	public boolean isPalindrome(int x) {
		int reverse = 0, originalNumber = x;
		while (x != 0) {
			int remainder = x % 10;
			reverse = 10 * reverse + remainder;

			x = x / 10;
		}
		System.out.println(reverse);
		return reverse == originalNumber;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Integer number");
		int num = scanner.nextInt();
		System.out.println(solution.isPalindrome(num));
		scanner.close();
	}
}
