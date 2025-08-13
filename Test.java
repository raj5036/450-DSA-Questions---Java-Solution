import java.util.*;

class PriorityQueue {
	Vector<Integer> v;

	PriorityQueue() {
		v = new Vector<Integer>();
	}

	PriorityQueue(int capacity) {
		v = new Vector<Integer>(capacity);
	}

	int parent(int i) {
		if (i == 0) {
			return i;
		}

		return (i - 1) / 2;
	}

	int left(int i) {
		return 2 * i + 1;
	}

	int right(int i) {
		return 2 * i + 2;
	}

	int size() {
		return v.size();
	}

	void swap(int i, int j) {
		int temp = v.get(i);
		v.setElementAt(v.get(j), i);
		v.setElementAt(temp, j);
	}

	void heapify_down(int i) {
		int largest = i;
		int left = left(i);
		int right = right(i);

		if (left < size() && v.get(i) < v.get(left)) {
			largest = left;
		} else if (right < size() && v.get(i) < v.get(right)) {
			largest = right;
		}

		if (largest != i) {
			swap(i, largest);

			heapify_down(largest);
		}
	}

	void add(int num) {

	}
}

public class Test {
	public static void main(String[] args) {
		System.out.println("Hi");
		PriorityQueue pq = new PriorityQueue();

		int[] nums = { 2, 3, 1, 23, 21, 11, 8 };
		for (int num : nums) {

		}
	}
}