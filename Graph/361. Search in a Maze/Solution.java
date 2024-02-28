import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	static boolean isInBound(int row, int col, int N) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}

	/*
	 * Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different
	 * directions.
	 * Space Complexity: O(m*n), Maximum Depth of the recursion tree(auxiliary
	 * space).
	 */
	static void findPathUtil(int[][] matrix, int n, int row, int col, boolean[][] visited, String path,
			ArrayList<String> paths) {
		if (row == n - 1 && col == n - 1) {
			paths.add(path);
			return;
		}

		if (isInBound(row - 1, col, n) && matrix[row - 1][col] == 1 && !visited[row - 1][col]) { // Up
			visited[row - 1][col] = true;
			findPathUtil(matrix, n, row - 1, col, visited, path + 'U', paths);
			visited[row - 1][col] = false;
		}
		if (isInBound(row + 1, col, n) && matrix[row + 1][col] == 1 && !visited[row + 1][col]) { // Down
			visited[row + 1][col] = true;
			findPathUtil(matrix, n, row + 1, col, visited, path + 'D', paths);
			visited[row + 1][col] = false;
		}
		if (isInBound(row, col - 1, n) && matrix[row][col - 1] == 1 && !visited[row][col - 1]) { // Left
			visited[row][col - 1] = true;
			findPathUtil(matrix, n, row, col - 1, visited, path + 'L', paths);
			visited[row][col - 1] = false;
		}
		if (isInBound(row, col + 1, n) && matrix[row][col + 1] == 1 && !visited[row][col + 1]) { // Right
			visited[row][col + 1] = true;
			findPathUtil(matrix, n, row, col + 1, visited, path + 'R', paths);
			visited[row][col + 1] = false;
		}

	}

	public static ArrayList<String> findPath(int[][] matrix, int n) {
		// Your code here
		ArrayList<String> ans = new ArrayList<>();
		if (matrix[0][0] == 0) { // If First block is blocked itself, then return.
			return ans;
		}
		boolean[][] visited = new boolean[n][n];
		for (boolean[] arr : visited) {
			Arrays.fill(arr, false);
		}

		visited[0][0] = true; // VVI: Mark the first cell as Visited
		findPathUtil(matrix, n, 0, 0, visited, "", ans);
		return ans;
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 0, 0, 0 },
				{ 1, 1, 0, 1 },
				{ 1, 1, 0, 0 },
				{ 0, 1, 1, 1 } };
		int[][] testcase2 = {
				{ 1, 1 },
				{ 1, 1 }
		};
		ArrayList<String> paths = findPath(testcase2, 2);
		for (String path : paths) {
			System.out.println(path);
		}
	}
}
