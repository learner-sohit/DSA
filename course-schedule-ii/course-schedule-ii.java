import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. Course Schedule II
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/course-schedule-ii/
 *
 * There are numCourses courses labeled 0 to numCourses-1.
 * Given prerequisites[i] = [a, b] meaning you must take course b before course a,
 * return the ordering of courses you should take to finish all courses.
 * If it is impossible (cycle exists), return an empty array.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS — Kahn's Algorithm (Topological Sort)
    // -------------------------------------------------------------------------
    // Model the problem as a directed graph: prereq → course.
    // A valid course order exists only if the graph is a DAG (no cycles).
    // Kahn's algorithm produces a topological ordering by repeatedly picking
    // nodes with in-degree 0. If all numCourses nodes are processed, the
    // resulting order array is the answer. Otherwise, a cycle exists → return [].
    //
    // Steps:
    //   1. Build adjacency list: prereq → course (directed edge).
    //   2. Compute in-degree for each course.
    //   3. Enqueue all courses with in-degree 0 (no prerequisites).
    //   4. BFS: dequeue a course, record it in order[], then reduce in-degrees
    //      of dependent courses; enqueue any that reach 0.
    //   5. If index == numCourses → return order[], else return [].
    //
    // Time Complexity:  O(V + E) — V = numCourses, E = prerequisites.length
    // Space Complexity: O(V + E) — adjacency list + queue + in-degree array
    // -------------------------------------------------------------------------

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            order[index++] = node;

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) q.offer(adjNode);
            }
        }

        return index == numCourses ? order : new int[] {};
    }
}
