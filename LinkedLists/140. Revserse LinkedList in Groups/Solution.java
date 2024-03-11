class Node {
	int data;
	Node prev, next;

	Node(int data) {
		this.data = data;
		this.prev = this.next = null;
	}
}

class LinkedList {
	Node head;

	public void insert(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node lastNode = head;

			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}

			lastNode.next = new Node(data); // Inserted new data
		}
	}

	public void reverse(Node head) {
		Node prev = null, current = head, next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;

			prev = current;
			current = next;
		}

		this.head = prev;
	}

	public Node reverseInGroups(Node head, int K) {
		if (head == null || head.next == null) {
			return head;
		}

		int real = K;
		Node prev = null, current = head, next = null;

		while (current != null && K > 0) {
			next = current.next;
			current.next = prev;

			prev = current;
			current = next;

			K--;
		}

		if (next != null) {
			head.next = reverseInGroups(head, real);
		}
		return prev;
	}

	public void display() {
		Node current = head;

		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.print("null");
	}
}

public class Solution {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();

		ll.insert(0);
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);

		ll.display();
	}
}
