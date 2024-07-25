import java.util.Arrays;

public class Solution {
	boolean isInBound(int row, int col, int M, int N) {
		return row >= 0 && row < M && col >= 0 && col < N;
	}

	void floodFillUtil(int[][] image, int row, int col, int M, int N, int startColor, int targetColor) {
		if (image[row][col] == targetColor) { // VVI
			return;
		}

		image[row][col] = targetColor;

		if (isInBound(row - 1, col, M, N) && image[row - 1][col] == startColor) { // Up
			floodFillUtil(image, row - 1, col, M, N, startColor, targetColor);
		}
		if (isInBound(row + 1, col, M, N) && image[row + 1][col] == startColor) { // Down
			floodFillUtil(image, row + 1, col, M, N, startColor, targetColor);
		}
		if (isInBound(row, col - 1, M, N) && image[row][col - 1] == startColor) { // Left
			floodFillUtil(image, row, col - 1, M, N, startColor, targetColor);
		}
		if (isInBound(row, col + 1, M, N) && image[row][col + 1] == startColor) { // Right
			floodFillUtil(image, row, col + 1, M, N, startColor, targetColor);
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int targetColor) {
		int M = image.length, N = image[0].length, startColor = image[sr][sc];

		floodFillUtil(image, sr, sc, M, N, startColor, targetColor);
		return image;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] image = {
				{ 1, 1, 1 },
				{ 1, 1, 0 },
				{ 1, 0, 1 }
		};
		int[][] ans = solution.floodFill(image, 1, 1, 2);
		for (int[] a : ans) {
			System.out.println(Arrays.toString(a));
		}
	}
}
