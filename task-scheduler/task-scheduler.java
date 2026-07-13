import java.util.*;

// ===== Approach 1: Greedy — Max Heap with Cycle Simulation =====
// Time Complexity: O(N * n) | Space Complexity: O(1) — heap size bounded by 26
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max Heap: always pick the most frequent remaining task first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq) {
            if (f > 0) maxHeap.offer(f);
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1; // Each CPU cycle window has size n+1

            // Fill the cycle window with the most frequent tasks
            while (cycle > 0 && !maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;
                if (count > 0) temp.add(count);
                time++;
                cycle--;
            }

            // Push remaining tasks back into the heap for next cycle
            for (Integer count : temp) {
                maxHeap.offer(count);
            }

            // If heap is empty, all tasks are done — no idle time needed
            if (maxHeap.isEmpty()) break;

            // Add idle slots to fill the rest of the cycle window
            time += cycle;
        }

        return time;
    }
}
