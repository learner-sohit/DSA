# Alien Dictionary

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/alien-dictionary/1)

## Problem Description

Given a sorted dictionary of an alien language with `N` words and `K` starting alphabets, find the order of characters in the alien language.

Return a string representing the character ordering. If no valid ordering exists (i.e., the input is contradictory), return `""`.

### Example

**Input:**
```
words = ["baa", "abcd", "abca", "cab", "cad"]
```

**Output:** `"bdac"`

**Explanation:**
By comparing adjacent words:
- `"baa"` vs `"abcd"` → `b` comes before `a`
- `"abcd"` vs `"abca"` → `d` comes before `a`
- `"abca"` vs `"cab"` → `a` comes before `c`
- `"cab"` vs `"cad"` → `b` comes before `d`

Topological order of these constraints → `"bdac"`

---

## Approach: Topological Sort — BFS (Kahn's Algorithm)

> **Key Insight:** The sorted word list gives us **ordering constraints** between characters. Comparing each adjacent pair of words, the **first differing character** tells us which letter comes earlier in the alien alphabet. We model these constraints as directed edges in a graph and find the topological order using Kahn's Algorithm.

### Algorithm

1. **Initialize graph**: collect all unique characters → build adjacency list and in-degree map.
2. **Derive edges**: for each adjacent word pair `(s1, s2)`:
   - Compare character by character.
   - On the **first mismatch** at position `j`: add edge `s1[j] → s2[j]`, increment in-degree of `s2[j]`.
   - **Edge case**: if no mismatch found but `s1` is longer than `s2`, the dictionary is invalid → return `""`.
3. **BFS (Kahn's)**: enqueue all characters with in-degree `0` → dequeue, append to answer, decrement neighbors' in-degrees, enqueue those reaching `0`.
4. If answer length `!=` total unique characters → **cycle exists** → return `""`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N × L + K) — N = number of words, L = avg word length, K = unique characters |
| **Space** | O(K + E) — adjacency list + in-degree map + queue |
