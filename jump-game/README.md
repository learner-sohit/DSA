# 55. Jump Game

**LeetCode Problem:** [https://leetcode.com/problems/jump-game/](https://leetcode.com/problems/jump-game/)

**Difficulty:** Medium

---

## Problem Description

You are given an integer array `nums`. You are initially positioned at the **first index** of the array. Each element `nums[i]` represents your **maximum jump length** at that position.

Return `true` if you can reach the last index, or `false` otherwise.

---

## Examples

**Example 1:**

**Input:** `nums = [2,3,1,1,4]`  
**Output:** `true`  
**Explanation:** Jump 1 step from index 0 to 1, then 3 steps to the last index.

---

**Example 2:**

**Input:** `nums = [3,2,1,0,4]`  
**Output:** `false`  
**Explanation:** You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

---

## Approaches

---

### Approach 2: Optimal — Greedy (Track Max Reachable Index)

**Idea:**  
At any index `i`, the farthest index we can reach from there is `i + nums[i]`. Maintain a running `maxIdx` representing the farthest index reachable so far. While iterating:
- If the current index `i` exceeds `maxIdx`, it means we can never reach `i` — return `false`.
- Otherwise, update `maxIdx = max(maxIdx, i + nums[i])`.

If we complete the loop without returning `false`, the last index is reachable.

**Algorithm:**
1. Initialize `maxIdx = nums[0]`.
2. For each index `i` from 1 to `n-1`:
   - If `i > maxIdx` → return `false`.
   - `maxIdx = max(maxIdx, i + nums[i])`.
3. Return `true`.

**Complexity:**
- **Time:** O(n) — single pass through the array.
- **Space:** O(1) — only one variable tracked.

---

### Approach 1: Brute Force — Recursion (Try All Jumps)

**Idea:**  
From each index, try every possible jump length (1 to `nums[idx]`). Recursively check if any jump leads to the last index. Return `true` if any path succeeds.

**Algorithm:**
1. `helper(nums, idx)`: if `idx >= nums.length - 1`, return `true`.
2. Try all jumps `i` from 1 to `nums[idx]`: if `helper(nums, idx + i)` returns `true`, return `true`.
3. If no jump works, return `false`.

**Complexity:**
- **Time:** O(n^n) — exponential branching at each step.
- **Space:** O(n) — recursion call stack depth.
