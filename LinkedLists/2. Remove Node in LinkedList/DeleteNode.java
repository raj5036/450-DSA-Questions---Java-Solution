
//   Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class DeleteNode {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;

		while (current.next != null) {
			if (current.next.val == val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}

		return dummy.next;
	}
}