public class Solution {

	public class ListNode {
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return add(l1, l2, 0);
	}

	private ListNode add(ListNode a, ListNode b, int carry) {
		if (a == null && b == null && carry == 0)
			return null;

		int sum = (a != null ? a.val : 0) + (b != null ? b.val : 0) + carry;
		ListNode node = new ListNode(sum % 10);
		node.next = add(a != null ? a.next : null, b != null ? b.next : null, sum / 10);
		return node;
	}
}
