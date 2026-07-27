# 127. Word Ladder

[Link to Problem on LeetCode](https://leetcode.com/problems/word-ladder/)

## Problem Description

Given a `beginWord`, an `endWord`, and a `wordList`, return the **number of words** in the shortest transformation sequence from `beginWord` to `endWord`, or `0` if no such sequence exists.

Rules:
- Only **one letter** can be changed at a time.
- Every intermediate word must exist in `wordList`.

### Example 1

**Input:**
```
beginWord = "hit", endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
```

**Output:** `5`

**Explanation:** `"hit" → "hot" → "dot" → "dog" → "cog"` — 5 words in the sequence.

### Example 2

**Input:**
```
beginWord = "hit", endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
```

**Output:** `0`

**Explanation:** `"cog"` is not in `wordList`, so no transformation sequence exists.

---

## Approach: BFS (Level-by-Level Word Transformation)

> **Key Insight:** Model each word as a graph node with edges between words that differ by exactly one character. Finding the **shortest transformation sequence** is equivalent to finding the **shortest path** in this graph — which BFS solves optimally.
>
> Instead of building the full graph (costly), we generate neighbors on the fly by trying all 26 letter substitutions at each position. A `HashSet` enables O(1) word lookups and serves as the visited tracker (words are removed once enqueued).

### Algorithm

1. Load `wordList` into a `HashSet` for O(1) lookup. If `endWord` is absent → return `0`.
2. Enqueue `(beginWord, level = 1)`.
3. BFS: for each dequeued `(word, level)`:
   - For each position `i` in `word`, try replacing with each char `'a'–'z'`.
   - If the new word equals `endWord` → return `level + 1` immediately.
   - If the new word is in the set → remove it (mark visited) and enqueue `(newWord, level + 1)`.
4. If BFS exhausts without finding `endWord` → return `0`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N × M × 26) — N = wordList size, M = word length, 26 char substitutions per position |
| **Space** | O(N) — HashSet + BFS queue |
