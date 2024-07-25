import java.util.*;

public class Solution {
	public static int doUnion(int arr1[], int arr2[]) { // GFG Accepted SOlution
        Set<Integer> set = new HashSet<>();
        
        for (int num: arr1) {
            set.add(num);
        }
        
        for (int num: arr2) {
            set.add(num);
        }
        
        return set.size();
    }

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {2, 5, 7, 9};

		System.out.println(doUnion(arr1, arr2));	
	}
}