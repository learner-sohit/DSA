import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 127. Word Ladder
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/word-ladder/
 *
 * Given a beginWord, an endWord, and a wordList, find the length of the
 * shortest transformation sequence from beginWord to endWord, where:
 *   - Only one letter can be changed at a time.
 *   - Each transformed word must exist in the wordList.
 * Return 0 if no such sequence exists.
 */

class Solution {

    // Helper class to track word and its current transformation level
    class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    // -------------------------------------------------------------------------
    // Approach: BFS (Level-by-Level Word Transformation)
    // -------------------------------------------------------------------------
    // Model the problem as a graph where each word is a node and an edge exists
    // between two words if they differ by exactly one character. We want the
    // shortest path from beginWord to endWord → BFS is the natural choice.
    //
    // To avoid generating the full graph (expensive), we:
    //   1. Try replacing each character position with 'a'-'z'.
    //   2. Check if the resulting word is in the word set.
    //   3. Remove words from the set once visited to prevent revisiting.
    //
    // Early exit: if the next word equals endWord, return level + 1 immediately.
    //
    // Steps:
    //   1. Load wordList into a HashSet for O(1) lookup.
    //   2. If endWord is not in the set, return 0 immediately.
    //   3. BFS: enqueue (beginWord, level=1); for each word, try all single-char
    //      replacements; if a valid word is found, enqueue it and remove from set.
    //   4. If BFS exhausts without reaching endWord, return 0.
    //
    // Time Complexity:  O(N * M * 26) — N = wordList size, M = word length
    // Space Complexity: O(N)          — HashSet + BFS queue
    // -------------------------------------------------------------------------

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int level = p.level;

            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (chars[i] == ch) continue;
                    chars[i] = ch;
                    String next = new String(chars);

                    if (next.equals(endWord)) return level + 1; // early exit
                    if (set.contains(next)) {
                        set.remove(next); // mark visited by removing from set
                        q.offer(new Pair(next, level + 1));
                    }
                }
            }
        }

        return 0; // no transformation sequence found
    }
}
