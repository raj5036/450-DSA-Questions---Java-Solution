import java.util.Arrays;

public class Solution {
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void sort012(int arr[], int n) { // GFG Accepted solution
		// code here
		int start = 0, end = arr.length - 1, index = 0;

		while (start <= end && index <= end) { // Put equals in Condition
			if (arr[index] == 0) {
				swap(arr, index, start);
				start++;
				index++;
			} else if (arr[index] == 2) {
				swap(arr, index, end);
				end--;
			} else {
				index++;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 2, 0, 2 };
		sort012(array, array.length);
		System.out.println(Arrays.toString(array));
	}
}
