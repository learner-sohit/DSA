# 45. Jump Game II

**LeetCode Problem:** [https://leetcode.com/problems/jump-game-ii/](https://leetcode.com/problems/jump-game-ii/)

**Difficulty:** Medium

---

## Problem Description

You are given a **0-indexed** array of integers `nums` of length `n`. You are initially positioned at `nums[0]`. Each element `nums[i]` represents the **maximum** length of a forward jump from index `i`.

Return the **minimum number of jumps** to reach `nums[n-1]`. The test cases are generated such that you can always reach `nums[n-1]`.

---

## Examples

**Example 1:**

**Input:** `nums = [2,3,1,1,4]`  
**Output:** `2`  
**Explanation:** The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

---

**Example 2:**

**Input:** `nums = [2,3,0,1,4]`  
**Output:** `2`

---

## Approaches

---

### Approach 3: Optimal — Single Pass Greedy (Active)

**Idea:**  
Think of jumps as "levels". Track `currentEnd` — the boundary of the current jump level — and `farthest` — the farthest index reachable from anywhere within this level. When the pointer `i` reaches `currentEnd`, we must make a jump: increment `jumps` and extend `currentEnd` to `farthest`. We stop just before the last index since we only count jumps needed to reach it.

**Algorithm:**
1. Initialize `jumps = 0`, `currentEnd = 0`, `farthest = 0`.
2. Iterate `i` from `0` to `n-2` (stop before last index):
   - Update `farthest = max(farthest, i + nums[i])`.
   - If `i == currentEnd`: we've exhausted the current jump level → `jumps++`, `currentEnd = farthest`.
3. Return `jumps`.

**Complexity:**
- **Time:** O(n) — single pass.
- **Space:** O(1) — three variables only.

---

### Approach 2: Better — BFS-style Level Jump

**Idea:**  
Think of reachable indices as BFS levels. `[low, high]` represents all indices reachable in `jumps` jumps. For the next level, find the farthest index reachable from any index in `[low, high]`. Expand the window and increment the jump count.

**Algorithm:**
1. Initialize `low = 0`, `high = 0`, `jumps = 0`.
2. While `high < n-1`:
   - Find `farthest = max(i + nums[i])` for all `i` in `[low, high]`.
   - `low = high + 1`, `high = farthest`, `jumps++`.
3. Return `jumps`.

**Complexity:**
- **Time:** O(n) — each index is visited once across all levels.
- **Space:** O(1).

---

### Approach 1: Brute Force — Recursion (Try All Jumps)

**Idea:**  
Recursively try every possible jump from each index. Track the global minimum jump count across all paths that reach the last index. Prune early if the current count already exceeds the minimum found.

**Algorithm:**
1. `helper(nums, idx, count)`: if `idx >= n-1`, update `min = min(min, count)`.
2. If `count >= min`, prune and return.
3. Try all jumps `i` from 1 to `nums[idx]`: recurse with `idx + i`, `count + 1`.

**Complexity:**
- **Time:** O(n^n) — exponential branching.
- **Space:** O(n) — recursion stack.
