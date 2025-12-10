public class MiddleStack {
	// Doubly linked list node
	private static class DLLNode {
		int data;
		DLLNode prev, next;

		DLLNode(int data) {
			this.data = data;
		}
	}

	private DLLNode head; // top of stack
	private DLLNode mid; // middle node
	private int count; // size of stack

	// Push element on top: O(1)
	public void push(int x) {
		DLLNode node = new DLLNode(x);

		node.next = head;
		if (head != null) {
			head.prev = node;
		}

		head = node;
		count++;

		// Update mid
		if (count == 1) {
			mid = node;
		} else if (count % 2 == 0) {
			// when count becomes even, move mid one step back
			mid = mid.prev;
		}
	}

	// Pop element from top: O(1)
	public int pop() {
		if (count == 0) {
			throw new RuntimeException("Stack is empty");
		}

		DLLNode oldHead = head;
		int item = oldHead.data;

		head = oldHead.next;
		if (head != null) {
			head.prev = null;
		}

		count--;

		if (count == 0) {
			mid = null;
		} else if (count % 2 == 1) {
			// when new count is odd, move mid one step forward
			mid = mid.next;
		}

		return item;
	}

	// Return middle element: O(1)
	public int findMiddle() {
		if (mid == null) {
			throw new RuntimeException("Stack is empty");
		}
		return mid.data;
	}

	// Delete middle element: O(1)
	public int deleteMiddle() {
		if (count == 0) {
			throw new RuntimeException("Stack is empty");
		}

		int item = mid.data;

		if (count == 1) {
			// Only one element
			head = null;
			mid = null;
			count = 0;
			return item;
		}

		int oldCount = count;
		DLLNode prev = mid.prev;
		DLLNode next = mid.next;

		// Remove mid from DLL
		if (prev != null) {
			prev.next = next;
		} else {
			// mid was head
			head = next;
		}

		if (next != null) {
			next.prev = prev;
		}

		count--;

		// Update mid pointer
		if (oldCount % 2 == 0) {
			// old count was even -> new mid is next of old mid
			mid = next;
		} else {
			// old count was odd -> new mid is prev of old mid
			mid = prev;
		}

		return item;
	}

	// Optional: helper to see size
	public int size() {
		return count;
	}
}
