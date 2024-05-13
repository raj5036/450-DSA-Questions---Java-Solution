import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {
	static class User {
		String name;
		int age;

		User(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	static class SortByAge implements Comparator<User> {
		public int compare(User u1, User u2) {
			return u1.age - u2.age;
		}
	}

	static void printList(List<User> list) {
		for (User user : list) {
			System.out.println(user.name + " " + user.age);
		}
	}

	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		list.add(new User("Raj", 26));
		list.add(new User("Sam", 21));
		list.add(new User("John", 30));

		printList(list);

		Collections.sort(list, new SortByAge()); // *****
		System.out.println("\nAfter Sorting");
		printList(list);
	}
}
