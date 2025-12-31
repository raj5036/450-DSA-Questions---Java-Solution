
public class Kata {
	static String alphabetPosition(String text) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c >= 'a' && c <= 'z') {
				sb.append(c - 'a' + 1).append(" ");
			} else if (c >= 'A' && c <= 'Z') {
				sb.append(c - 'A' + 1).append(" ");
			}
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(alphabetPosition("The sunset sets at twelve o' clock."));
	}
}
