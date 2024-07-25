import java.util.*;

public class Test {
	static void swap (int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void moveNegativeToOneSide (int[] arr, int N) {
		int start = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] < 0) {
				swap(arr, i, start);
				start++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { -1, 1, -2, 2, -3, 3, -4, 4, -5, 5 };
		int N = arr.length;

		moveNegativeToOneSide(arr, N);

		System.out.println(Arrays.toString(arr));
	}
}