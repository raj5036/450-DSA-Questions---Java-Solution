
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			String[] s = br.readLine().trim().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			char[][] grid = new char[n][m];
			for (int i = 0; i < n; i++) {
				String[] S = br.readLine().trim().split(" ");
				for (int j = 0; j < m; j++) {
					grid[i][j] = S[j].charAt(0);
				}
			}
			Solution obj = new Solution();
			int ans = obj.numIslands(grid);
			System.out.println(ans);
		}
	}
}
// } Driver Code Ends

class Solution {
	// Function to find the number of islands.
	public int numIslands(char[][] grid) {
		// Code here
		int count = 0, N = grid.length, M = grid[0].length;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (grid[i][j] == '1') {
					count++;
					util(grid, i, j, N, M);
				}
		return count;
	}

	static void util(char[][] grid, int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] == '0')
			return;

		grid[i][j] = '0';

		util(grid, i - 1, j, N, M); // up
		util(grid, i + 1, j, N, M); // down
		util(grid, i, j - 1, N, M); // left
		util(grid, i, j + 1, N, M); // right

		util(grid, i - 1, j - 1, N, M); // diagonally up left
		util(grid, i - 1, j + 1, N, M); // diagonally up right
		util(grid, i + 1, j - 1, N, M); // diagonally down left
		util(grid, i + 1, j + 1, N, M); // diagonally down right
	}
}