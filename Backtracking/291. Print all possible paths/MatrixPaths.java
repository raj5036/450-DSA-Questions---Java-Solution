import java.util.ArrayList;
import java.util.List;

public class MatrixPaths {
	// To store the matrix dimensions
	static int M, N;

	// Function to print the path taken to reach the
	// destination
	static void printPath(List<Integer> path) {
		for (int i : path) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	// Function to find all possible paths in the matrix
	// from the top-left cell to the bottom-right cell
	static void findPaths(int[][] arr, List<Integer> path,
			int i, int j) {
		// If it's the bottom-right cell, print the path
		if (i == M - 1 && j == N - 1) {
			path.add(arr[i][j]);
			printPath(path);
			path.remove(path.size() - 1);
			return;
		}

		// Boundary cases: Check if we are out of the matrix
		if (i < 0 || i >= M || j < 0 || j >= N) {
			return;
		}

		// Include the current cell in the path
		path.add(arr[i][j]);

		// Move right in the matrix
		if (j + 1 < N) {
			findPaths(arr, path, i, j + 1);
		}

		// Move down in the matrix
		if (i + 1 < M) {
			findPaths(arr, path, i + 1, j);
		}

		// Backtrack: Remove the current cell from the
		// current path
		path.remove(path.size() - 1);
	}

	// Driver code
	public static void main(String[] args) {
		// Input matrix
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// To store the path
		List<Integer> path = new ArrayList<>();

		// Starting cell (0, 0)
		int i = 0, j = 0;

		M = arr.length;
		N = arr[0].length;

		// Function call
		findPaths(arr, path, i, j);
	}
}