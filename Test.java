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

	void append(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}

			lastNode.next = new Node(data);
		}
	}

	void remove(int data) {
		if (head == null) {
			System.out.println("Nothing to remove");
		} else if (head.data == data) {
			head = head.next;
		} else {
			Node current = head;
			while (current != null) {
				if (current.next != null && current.next.data == data) {
					current.next = current.next.next;
					break;
				}
				current = current.next;
			}

			if (current == null) {
				System.out.println("Node not found");
			}
		}
	}

	void reverse() {
		Node current = head, prev = null, next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;

			prev = current;
			current = next;
		}

		this.head = prev;
	}

	void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.print("null\n");
	}
}

public class Test {
	public static void main(String[] args) {
		System.out.println("Hi");
		LinkedList ll = new LinkedList();
		ll.append(0);
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.print();

		ll.reverse();
		ll.print();
	}
}