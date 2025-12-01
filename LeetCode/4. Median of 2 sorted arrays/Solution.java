class Solution {
	void insertIntoQueue(PriorityQueue<Integer> pq, int[] nums) {
		for (int num : nums) {
			pq.add(num);
		}
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		insertIntoQueue(pq, nums1);
		insertIntoQueue(pq, nums2);

		int count = 0;
		boolean isEven = pq.size() % 2 == 0;
		int median_idx = isEven ? pq.size() / 2 : ((pq.size() / 2) + 1);

		while (pq.size() > 0) {
			int peek = pq.peek();
			pq.poll();
			count++;

			if (isEven) {
				if (count == median_idx) {
					int ele1 = peek;
					int ele2 = pq.peek();
					System.out.println(ele1);
					System.out.println(ele2);

					return (double) ((ele1 + ele2) / 2.0);
				}
			} else {
				if (count == median_idx) {
					return (double) (peek);
				}
			}
		}

		return -1;
	}
}