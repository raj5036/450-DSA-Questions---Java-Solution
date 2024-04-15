import java.util.*;;

public class Solution {
	static void maximumSubArray(int[] array, int n, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
		for (int i = 0; i < n; i++) {
			for (int j = i; j < i + K - 1 && (i + K - 1) < n; j++) {
				pq.add(array[j]);
			}
			System.out.println(pq.poll() + " ");
			pq.clear();
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int n = array.length;
		int K = 3;

		maximumSubArray(array, n, K);
	}
}
