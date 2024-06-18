public class Solution {
	String countAndSay(int n) {
		String number = String.valueOf(n);

		String output = "";
		int count = 1;
		char currentCharacter = number.charAt(0);

		for (int i = 1; i < number.length(); i++) {
			if (currentCharacter == number.charAt(i)) {
				count += 1;
			} else {
				output += String.valueOf(count) + String.valueOf(currentCharacter);
				currentCharacter = number.charAt(i);
				count = 1;
			}
		}

		output += String.valueOf(count) + String.valueOf(currentCharacter);

		return output;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countAndSay(3344));
	}
}
