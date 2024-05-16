public class BinarySearch {
	static void binarySearch_recursion(int[] arr, int N, int x, int left, int right) {
		if (left > right) {
			System.out.println("Element is not found");
			return;
		}

		int mid = left + (right - left) / 2;

		if (arr[mid] == x) {
			System.out.println("Element found at index: " + mid);
			return;
		}

		if (x < arr[mid]) {
			binarySearch_recursion(arr, N, x, left, mid - 1);
		}

		if (x > arr[mid]) {
			binarySearch_recursion(arr, N, x, mid + 1, right);
		}
	}

	static void binarySearch_iteration(int[] arr, int N, int x) {
		int left = 0, right = N - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == x) {
				System.out.println("Element found at index: " + mid);
				return;
			}

			if (x < arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println("Element is not found");
	}

	public static void main(String[] args) {
		int[] arr = { -2, 1, 2, 4, 6, 8, 9, 10 };
		int N = arr.length;

		binarySearch_recursion(arr, N, -2, 0, N - 1);
		binarySearch_iteration(arr, N, 90);
	}
}
