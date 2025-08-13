
// https://www.geeksforgeeks.org/nearly-sorted-algorithm/
// Java program to sort a nearly sorted array
import java.util.*;

public class Solution {

	// Function to sort a nearly sorted array
	// where every element is at most
	// k positions away from its target position.
	static void nearlySorted(int[] arr, int k) {

		// Length of array
		int n = arr.length;

		// Creating a min heap
		PriorityQueue<Integer> pq = new PriorityQueue();

		// Pushing first k elements in pq
		for (int i = 0; i < k; i++)
			pq.add(arr[i]);

		int i;
		for (i = k; i < n; i++) {
			pq.add(arr[i]);

			// Size becomes k+1 so pop it
			// and add minimum element in (i-k) index
			arr[i - k] = pq.poll();
		}

		// Putting remaining elements in array
		while (!pq.isEmpty()) {
			arr[i - k] = pq.poll();
			i++;
		}
	}

	public static void main(String[] args) {
		int k = 3;
		int[] arr = { 6, 5, 3, 2, 8, 10, 9 };

		nearlySorted(arr, k);

		for (int x : arr) {
			System.out.print(x + " ");
		}
	}
}