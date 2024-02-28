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

	boolean isPalindrome() {
		int originalNumber = 0;
		Node currentNode = head;
		while (currentNode != null) {
			int data = currentNode.data;
			originalNumber = originalNumber * 10 + data;
			currentNode = currentNode.next;
		}
		System.out.println("originalNumber: " + originalNumber);

		int tempVar = originalNumber, reverse = 0;
		while (tempVar != 0) {
			int remainder = tempVar % 10;
			reverse = 10 * reverse + remainder;
			tempVar = tempVar / 10;
		}
		System.out.println("reverse: " + reverse);
		return originalNumber == reverse;
	}
}

public class PalindromeLinkedList {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(2);
		linkedList.insert(1);
		linkedList.display();

		System.out.println("\nIsPalindrome: " + linkedList.isPalindrome());
	}
}
