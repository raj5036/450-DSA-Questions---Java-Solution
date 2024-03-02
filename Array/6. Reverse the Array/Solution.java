import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static void reverseArray(int[] arr, int n) {
		for (int i = 0; i < n / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[n - i - 1];
			arr[n - i - 1] = temp;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the length of Array: ");
		int length = scanner.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			System.out.println("Element at Index " + i);
			arr[i] = scanner.nextInt();
		}
		scanner.close();

		System.out.println("Array before reversing " + Arrays.toString(arr));

		reverseArray(arr, length);
		System.out.println("Array after reversing " + Arrays.toString(arr));
	}
}