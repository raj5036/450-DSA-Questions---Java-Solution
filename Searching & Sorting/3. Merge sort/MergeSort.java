import java.util.Arrays;

public class MergeSort {
	static void merge(int[] arr, int N, int left, int mid, int right) {
		int leftArraySize = mid - left + 1; // ** */
		int rightArraySize = right - mid;

		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; i++) {
			leftArray[i] = arr[left + i];
		}

		for (int i = 0; i < rightArraySize; i++) {
			rightArray[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0, k = left;
		while (i < leftArraySize && j < rightArraySize) {
			if (leftArray[i] < rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
				k++;
			} else {
				arr[k] = rightArray[j];
				j++;
				k++;
			}
		}

		while (i < leftArraySize) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArraySize) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	static void sort(int[] arr, int N, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;

			sort(arr, N, left, mid);
			sort(arr, N, mid + 1, right);

			merge(arr, N, left, mid, right);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 3 };
		int N = arr.length;

		sort(arr, N, 0, N - 1);

		System.out.println(Arrays.toString(arr));
	}
}
