/*
 * 	1. If n==1 then return 0, Because in the question given that initially, we are at first index that means no need to jump if n==1. 
	2. If arr[0]==0 then return -1, As if the value of first index is zero that means we can't make any jump from the start.
	3. Initialize 3 variables
		maxrange=arr[0]: The variable maxrange stores at all times the maximal reachable index in the array.
		jump = 1: stores the number of jumps necessary to reach the maximal reachable position. It also indicates the current jump we are making in the array.
		step = arr[0]: The variable step stores the number of steps we can still take in the current jump 'jump' (and is initialized with value at index 0, i.e. initial number of steps)
	Now, starting iteration from index 1, the above values are updated as follows.
	First, we test whether we have reached the end of the array, in that case, we just need to return the jump variable.
	Now we update the maxReach. This is equal to the maximum of maxrange and i+arr[i](the number of steps we can take from the current position).
	We used up a step to get to the current index, so steps have to be decreased. 
	If no more steps are remaining (i.e. steps=0, then we must have used a jump. Therefore increase jump. Since we know that it is possible somehow to reach maxrange, we again initialize the steps to the number of steps to reach maxrange from position i. But before re-initializing the step, we also check whether a step is becoming zero or negative. In this case, It is not possible to reach further so return -1.
 */
public class Solution {
	static int minJumps(int arr[]) {
		if (arr.length <= 1)
			return 0;

		// Return -1 if not possible to jump
		if (arr[0] == 0)
			return -1;

		// initialization
		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;

		// Start traversing array
		for (int i = 1; i < arr.length; i++) {
			// Check if we have reached the end of the array
			if (i == arr.length - 1)
				return jump;

			// updating maxReach
			maxReach = Math.max(maxReach, i + arr[i]);

			// we use a step to get to the current index
			step--;

			// If no further steps left
			if (step == 0) {
				// we must have used a jump
				jump++;

				// Check if the current index/position or lesser index
				// is the maximum reach point from the previous indexes
				if (i >= maxReach)
					return -1;

				// re-initialize the steps to the amount
				// of steps to reach maxReach from position i.
				step = maxReach - i;
			}
		}

		return -1;
	}
}
