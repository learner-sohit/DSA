import java.util.ArrayList;
import java.util.Arrays;

// ===== Approach 1: Greedy — Sort by Profit + Slot Scheduling =====
// Time Complexity: O(n log n + n * maxDeadline) | Space Complexity: O(maxDeadline)
class Solution {
    class Jobs {
        int deadline;
        int profit;

        Jobs(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int maxDeadline = 0;
        Jobs[] job = new Jobs[n];

        for (int i = 0; i < n; i++) {
            job[i] = new Jobs(deadline[i], profit[i]);
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // Sort jobs by profit in descending order
        Arrays.sort(job, (a, b) -> b.profit - a.profit);

        boolean[] slot = new boolean[maxDeadline + 1];

        int jobCount = 0;
        int maxProfit = 0;

        for (Jobs i : job) {
            // Try to schedule as late as possible within the deadline
            int j = i.deadline;
            while (j >= 1) {
                if (!slot[j]) {
                    slot[j] = true;
                    jobCount++;
                    maxProfit += i.profit;
                    break;
                } else {
                    j--;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(jobCount);
        list.add(maxProfit);

        return list;
    }
}
