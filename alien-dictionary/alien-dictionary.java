import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Alien Dictionary
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/alien-dictionary/1
 *
 * Given a sorted dictionary of an alien language, find the order of characters
 * in that language. Return a string of characters in the correct order.
 * If no valid ordering exists (cycle), return "".
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Topological Sort — BFS (Kahn's Algorithm)
    // -------------------------------------------------------------------------
    // The sorted word list gives us ordering constraints between characters.
    // By comparing adjacent words character by character, we can derive directed
    // edges: the first differing character tells us which letter comes before
    // the other in the alien alphabet.
    //
    // Steps:
    //   1. Initialize adjacency list and in-degree map for every unique character.
    //   2. Compare each adjacent pair of words:
    //      - Find the first differing character → add directed edge u → v.
    //      - Edge case: if word1 is longer than word2 and word2 is a prefix
    //        of word1, the input is invalid → return "".
    //   3. Enqueue all characters with in-degree 0.
    //   4. BFS (Kahn's): dequeue a character, append to answer, decrement
    //      in-degrees of neighbors, enqueue those reaching 0.
    //   5. If answer length != total unique characters → cycle exists → return "".
    //
    // Time Complexity:  O(N * L + K)  — N = words, L = avg word length, K = unique chars
    // Space Complexity: O(K + E)      — adjacency list + in-degree map + queue
    // -------------------------------------------------------------------------

    public String findOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize graph nodes for every character seen
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new ArrayList<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Derive ordering edges from adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            boolean found = false;
            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    char u = s1.charAt(j);
                    char v = s2.charAt(j);
                    adj.get(u).add(v);
                    indegree.put(v, indegree.get(v) + 1);
                    found = true;
                    break;
                }
            }

            // Invalid case: "abc" before "ab" in sorted order is impossible
            if (!found && s1.length() > s2.length()) return "";
        }

        // Enqueue all characters with in-degree 0
        Queue<Character> q = new LinkedList<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) q.offer(ch);
        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            ans.append(curr);

            for (char next : adj.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.offer(next);
            }
        }

        // Cycle detected — not all characters could be ordered
        if (ans.length() != indegree.size()) return "";

        return ans.toString();
    }
}
