public class Solution {
	public static int kthSmallest(int[] arr, int l, int r, int k) { // GFG accepted solution
		// Your code here
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : arr) {
			pq.add(num);
		}

		while (pq.size() > 0) {
			if (k == 1) {
				break;
			}
			pq.poll();
			k--;
		}
		return pq.peek();
	}

	public static void main(String[] args) {

	}
}
