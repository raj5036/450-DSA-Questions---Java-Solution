import java.util.Arrays;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node head;

	void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			this.head = newNode;
		} else {
			Node lastNode = this.head;
			while (lastNode.next != null) { // VVI (Always check lastNode.next in these cases)
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}
	}

	void display() {
		Node currentNode = this.head;
		while (currentNode != null) {
			System.out.print(currentNode.data + "->");
			currentNode = currentNode.next;
		}
		System.out.print("null\n");
	}

	int getNodeCount() {
		int count = 0;
		Node current = head;

		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	Node segregateEvenOdd() {
		int[] data = new int[this.getNodeCount()];
		Node current = head;
		int index = 0;

		while (current != null) {
			data[index++] = current.data;
			current = current.next;
		}

		int j = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] % 2 == 0) {
				if (i != j) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
				j++;
			}
		}

		System.out.println("data" + Arrays.toString(data));

		current = head;
		index = 0;
		while (current != null) {
			current.data = data[index++];
			current = current.next;
		}
		return head;
	}
}

public class SegregateEvenOdd {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(17);
		linkedList.insert(8);
		linkedList.insert(2);
		linkedList.insert(9);
		linkedList.insert(11);
		linkedList.insert(13);
		linkedList.insert(20);
		linkedList.insert(22);

		linkedList.display();

		linkedList.segregateEvenOdd();
		linkedList.display();
	}
}