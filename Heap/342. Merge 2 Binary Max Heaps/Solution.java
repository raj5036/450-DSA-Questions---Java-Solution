import java.util.Arrays;

public class Solution {
	static void merge(int[] a, int[] b, int m, int n) { // GFG Accepted Solution
		int i = 0, j = 0, k = 0;
		int[] mergedArray = new int[m + n];
		while (i < m && j < n) {
			if (a[i] > b[j]) {
				mergedArray[k] = a[i];
				k++;
				i++;
			} else {
				mergedArray[k] = b[j];
				k++;
				j++;
			}
		}

		while (i < m) {
			mergedArray[k] = a[i];
			k++;
			i++;
		}

		while (j < n) {
			mergedArray[k] = b[j];
			k++;
			j++;
		}

		System.out.println(Arrays.toString(mergedArray));
	}

	public static void main(String[] args) {
		int a[] = { 10, 5, 6, 2 };
		int b[] = { 12, 7, 9 };

		merge(a, b, a.length, b.length);
	}
}
