import java.util.Comparator;
import java.util.PriorityQueue;

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "Person -> name: " + this.name + ", age: " + this.age;
	}
}

public class Solution {
	static void printPQ(PriorityQueue<Person> pq) {
		while (!pq.isEmpty()) {
			Person p = pq.poll();
			System.out.println(p.toString());
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("Raj", 26);
		Person p2 = new Person("John", 21);
		Person p3 = new Person("Ally", 11);

		// Compare using age
		PriorityQueue<Person> pq1 = new PriorityQueue<>(Comparator.comparing(Person::getAge));
		pq1.add(p1);
		pq1.add(p2);
		pq1.add(p3);

		printPQ(pq1);

		// Compare using name
		PriorityQueue<Person> pq2 = new PriorityQueue<>(Comparator.comparing(Person::getName));
		pq2.add(p1);
		pq2.add(p2);
		pq2.add(p3);

		printPQ(pq2);
	}
}
