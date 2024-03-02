import java.util.Arrays;

public class Solution {
	static int[] mergeArray(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];
		int i = 0, j = 0, k = 0;
		while (i < a1.length && j < a2.length && k < a3.length) {
			if (a1[i] < a2[j]) {
				a3[k] = a1[i];
				i++;
				k++;
			} else {
				a3[k] = a2[j];
				j++;
				k++;
			}
		}

		while (i < a1.length) {
			a3[k] = a1[i];
			i++;
			k++;
		}

		while (j < a2.length) {
			a3[k] = a2[j];
			j++;
			k++;
		}

		return a3;
	}

	public static void main(String[] args) {
		int[] a1 = { 1, 4, 5, 9, 11 };
		int[] a2 = { 2, 3, 45, 56, 98, 101 };

		int[] a3 = mergeArray(a1, a2);
		System.out.println(Arrays.toString(a3));
	}
}