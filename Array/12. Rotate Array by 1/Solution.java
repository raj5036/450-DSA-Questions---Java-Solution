import java.util.Comparator;

public class Solution {
	public void rotate(int arr[], int n) { // GFG Accepted solution
		int lastEle = arr[n - 1];
		for (int i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = lastEle;
	}

	public static void main(String[] args) {

	}
}
