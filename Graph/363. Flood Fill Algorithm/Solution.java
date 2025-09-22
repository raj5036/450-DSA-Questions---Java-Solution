class Solution {
	public void util(int[][] image, int r, int c, int originalColor, int newColor) {
		if (r < 0 ||
				r >= image.length ||
				c < 0 ||
				c >= image[0].length ||
				image[r][c] != originalColor ||
				image[r][c] == newColor // This is the most important condition
		) {
			return;
		}

		image[r][c] = newColor;

		util(image, r - 1, c, originalColor, newColor);
		util(image, r + 1, c, originalColor, newColor);
		util(image, r, c - 1, originalColor, newColor);
		util(image, r, c + 1, originalColor, newColor);
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		util(image, sr, sc, image[sr][sc], newColor);
		return image;

	}
}