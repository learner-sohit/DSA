import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2685. Count the Number of Complete Components
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/count-the-number-of-complete-components/
 *
 * You are given an integer n (number of vertices, labeled 0 to n-1) and a list
 * of undirected edges. A connected component is complete if every pair of its
 * vertices is directly connected. Return the number of complete components.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach 1: Brute Force — BFS + pairwise edge check
    // -------------------------------------------------------------------------
    // Find each connected component via BFS, then check every pair of vertices
    // in the component against the edge list to confirm all edges exist.
    //
    // Time Complexity:  O(V + E + C^2 * E) — C = component size, E = edges
    // Space Complexity: O(V + E)            — adjacency list + visited array
    // -------------------------------------------------------------------------

    /*
    public int countCompleteComponents_bruteForce(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] isVisited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                isVisited[i] = true;

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    component.add(node);
                    for (int x : adj.get(node)) {
                        if (!isVisited[x]) {
                            isVisited[x] = true;
                            q.offer(x);
                        }
                    }
                }

                boolean isComplete = true;
                outer:
                for (int j = 0; j < component.size() - 1; j++) {
                    for (int k = j + 1; k < component.size(); k++) {
                        int u = component.get(j);
                        int v = component.get(k);
                        boolean found = false;
                        for (int[] edge : edges) {
                            if ((edge[0] == u && edge[1] == v) || (edge[0] == v && edge[1] == u)) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) { isComplete = false; break outer; }
                    }
                }
                if (isComplete) completeComponents++;
            }
        }
        return completeComponents;
    }
    */

    // -------------------------------------------------------------------------
    // Approach 2: Optimal — BFS + degree-sum formula
    // -------------------------------------------------------------------------
    // A component with V vertices is complete iff it has exactly V*(V-1)/2 edges.
    // During BFS, count vertices and sum up all degrees. Since each edge is
    // counted twice (once per endpoint), actual edges = degreeSum / 2.
    // Compare with the expected count for a complete graph.
    //
    // Time Complexity:  O(V + E) — single BFS pass over all vertices and edges
    // Space Complexity: O(V + E) — adjacency list + visited array + BFS queue
    // -------------------------------------------------------------------------

    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] isVisited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                int vertices = 0;
                int degreeSum = 0;

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    vertices++;
                    degreeSum += adj.get(node).size();
                    for (int x : adj.get(node)) {
                        if (!isVisited[x]) {
                            isVisited[x] = true;
                            q.offer(x);
                        }
                    }
                }

                int totalEdges = degreeSum / 2;
                int expected = vertices * (vertices - 1) / 2;
                if (totalEdges == expected) completeComponents++;
            }
        }
        return completeComponents;
    }
}
