import java.util.*;

public class StringSplit {
	public static String[] solution(String s) {
		int length = s.length();
		ArrayList<String> ans = new ArrayList<>();
		int index = 0;
		while (index < length) {
			if (index == length - 1) {
				ans.add(s.substring(index) + '_');
			} else {
				ans.add(s.substring(index, index + 2));
			}
			index += 2;
		}

		return ans.toArray(new String[0]);
	}

	public static void main(String[] args) {
		String s = "abc";
		System.out.println(Arrays.toString(solution(s)));
	}
}