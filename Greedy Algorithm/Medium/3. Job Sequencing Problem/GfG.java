// https://www.geeksforgeeks.org/dsa/job-sequencing-problem/

/*
 * 1. Store jobs as pairs of (Deadline, Profit).
 * 2. Sort Jobs Based on Deadline: We sort the jobs array in ascending order of deadline 
 * 	  so that we prioritize jobs with earlier deadlines are considered first.
 * 3. For each job (deadline, profit) in the sorted list:
 *     1. If the job can be scheduled within its deadline (i.e., the number of jobs scheduled so far is less than the deadline), push its profit into the heap. 
 *     2. If the heap is full (equal to deadline), replace the existing lowest profit job with the current job if it has a higher profit.
 *        This ensures that we always keep the most profitable jobs within the available slots.
 * 4. Traverse through the heap and store the total profit and the count of jobs.
 */
// Java program to solve job sequencing
// problem with maximum profit
import java.util.*;

public class GfG {

	static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
		int n = deadline.length;
		ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));

		// Pair the profit and deadline of all the jobs together
		List<int[]> jobs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			jobs.add(new int[] { deadline[i], profit[i] });
		}

		// Sort the jobs based on deadline in ascending order
		jobs.sort(Comparator.comparingInt(a -> a[0]));

		// Min-heap to maintain the scheduled jobs based on profit
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int[] job : jobs) {

			// If job can be scheduled within its deadline
			if (job[0] > pq.size()) {
				pq.add(job[1]);
			}

			// Replace the job with the lowest profit
			else if (!pq.isEmpty() && pq.peek() < job[1]) {
				pq.poll();
				pq.add(job[1]);
			}
		}

		while (!pq.isEmpty()) {
			ans.set(1, ans.get(1) + pq.poll());
			ans.set(0, ans.get(0) + 1);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] deadline = { 2, 1, 2, 1, 1 };
		int[] profit = { 100, 19, 27, 25, 15 };
		ArrayList<Integer> result = jobSequencing(deadline, profit);
		System.out.println(result.get(0) + " " + result.get(1));
	}
}