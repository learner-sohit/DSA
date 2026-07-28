import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. Course Schedule
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/course-schedule/
 *
 * There are numCourses courses labeled 0 to numCourses-1.
 * Given prerequisites[i] = [a, b] meaning you must take course b before course a,
 * return true if you can finish all courses, false otherwise.
 *
 * This is equivalent to detecting whether a directed graph has a cycle.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS — Kahn's Algorithm (Topological Sort)
    // Time Complexity:  O(V + E) — V = numCourses, E = prerequisites.length
    // Space Complexity: O(V + E) — adjacency list + queue + in-degree array
    // -------------------------------------------------------------------------

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];

            adj.get(prereq).add(course); // directed edge: prereq → course
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) q.offer(course);
        }

        int completedCourses = 0;

        while (!q.isEmpty()) {
            int currentCourse = q.poll();
            completedCourses++;

            for (int nextCourse : adj.get(currentCourse)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) q.offer(nextCourse);
            }
        }

        return completedCourses == numCourses;
    }
}
