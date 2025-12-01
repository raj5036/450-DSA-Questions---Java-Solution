public class WordSearch {
	static void wordSearch(char[][] grid, String word) {
		final int R = grid.length, C = grid[0].length;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == word.charAt(0)) {

				}
			}
		}
	}

	public static void main(String[] args) {
		char[][] grid = {
				{ 'a', 'b', 'a', 'b' },
				{ 'a', 'b', 'e', 'b' },
				{ 'e', 'b', 'e', 'b' }
		};

		String word = "abe";

	}
}
