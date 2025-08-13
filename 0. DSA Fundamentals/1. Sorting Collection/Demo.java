import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
	static void printList(List<Character> list) {
		for (Character c : list) {
			System.out.print(c + " ");
		}
	}

	public static void main(String[] args) {
		List<Character> list = new ArrayList<>();
		for (char c = 'z'; c >= 'a'; c--) {
			list.add(c);
		}

		printList(list);

		Collections.sort(list); // *****
		System.out.println("\nAfter Sorting");
		printList(list);
	}
}
