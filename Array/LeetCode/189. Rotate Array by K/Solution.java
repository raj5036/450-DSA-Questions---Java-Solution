import java.util.Arrays;

public class Solution {
	public static int[] rotate(int[] nums, int K) {
		int N = nums.length;
		K = K % N;

		int[] rotatedArray = new int[N];
		int index = N - K;
		for (int i = 0; i < K; i++) {
			rotatedArray[i] = nums[index++];
		}
		index = 0;
		for (int i = K; i < N; i++) {
			rotatedArray[i] = nums[index++];
		}
		return rotatedArray;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int K = 2;
		System.out.println(Arrays.toString(rotate(array, K)));
	}
}

// { 5, 6, 1, 2, 3, 4}
