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
