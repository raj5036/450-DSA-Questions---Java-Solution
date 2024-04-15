import java.util.Arrays;

public class Solution {
	static void heapify(int[] array, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && array[left] > array[i]) {
			largest = left;
		}
		if (right < n && array[right] > array[i]) {
			largest = right;
		}

		if (largest != i) {
			// Swap largest node with i
			int temp = array[largest];
			array[largest] = array[i];
			array[i] = temp;

			heapify(array, n, largest);
		}
	}

	static void buildMaxHeap(int[] array, int n) {
		int startIndex = (n / 2) - 1;
		for (int i = startIndex; i >= 0; i--) {
			heapify(array, startIndex, i);
		}
	}

	public static void main(String[] args) {
		int[] array = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };

		buildMaxHeap(array, array.length);

		System.out.println(Arrays.toString(array));
	}
}
