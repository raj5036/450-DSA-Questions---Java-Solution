public class Solution { // Same as sorting 0, 1, 2
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void threeWayPartition(int arr[], int a, int b) {
		// code here
		int n = arr.length;
		int i = 0, j = n - 1, index = 0;
		while (i <= j && index <= j) {
			if (arr[index] < a) {
				swap(arr, index, i);
				index++;
				i++;
			} else if (arr[index] > b) {
				swap(arr, index, j);
				j--;
			} else {
				index++;
			}
		}
	}

	public static void main(String[] args) {

	}
}
