import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static ArrayList<ArrayList<Integer>> uniqueRow(int[][] matrix, int R, int C) {
		ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (int[] row : matrix) {
			String rowKey = Arrays.toString(row);
			if (!set.contains(rowKey)) {
				ArrayList<Integer> answer = new ArrayList<>();
				for (int i = 0; i < row.length; answer.add(row[i]), i++)
					;
				answers.add(answer);
				set.add(rowKey);
			}
		}
		return answers;
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 0, 1, 1 },
				{ 1, 1, 1, 1 },
				{ 1, 0, 1, 1 },
				{ 1, 0, 2, 1 }
		};
		ArrayList<ArrayList<Integer>> answers = uniqueRow(matrix, matrix.length, matrix[0].length);
		for (ArrayList<Integer> answer : answers) {
			System.out.println(answer);
		}
	}
}
