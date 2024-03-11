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
		System.out.println();
	}
}

public class SegregateEvenOdd {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(17);

	}
}