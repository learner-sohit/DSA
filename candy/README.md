# 135. Candy

**LeetCode Problem:** [https://leetcode.com/problems/candy/](https://leetcode.com/problems/candy/)

**Difficulty:** Hard

---

## Problem Description

There are `n` children standing in a line. Each child is assigned a rating value given in the integer array `ratings`.

You are giving candies to these children subjected to the following requirements:
- Each child must have **at least one** candy.
- Children with a **higher rating** than their adjacent neighbors must receive **more candies** than those neighbors.

Return the **minimum number of candies** you need to distribute.

---

## Examples

**Example 1:**

**Input:** `ratings = [1,0,2]`  
**Output:** `5`  
**Explanation:** Give candies `[2,1,2]`. Total = 5.

---

**Example 2:**

**Input:** `ratings = [1,2,2]`  
**Output:** `4`  
**Explanation:** Give candies `[1,2,1]`. Total = 4. The third child gets 1 candy because it's not strictly higher than the second.

---

## Approaches

---

### Approach 3: Optimal — Single Pass Slope Counting (Active)

**Idea:**  
Instead of two separate array passes, traverse the ratings once and process each "slope" (ascending or descending sequence) as a unit. For each ascending run, count up from 1. For each descending run, count down from 1. The peak child's candy count is the max of the ascending length and descending length, so if the down-slope exceeds the peak, add the difference.

**Algorithm:**
1. Start with `sum = 1`, `i = 1`.
2. While `i < n`:
   - **Equal ratings:** add 1 candy, advance `i`.
   - **Ascending run:** increment `peak` for each step up, add `peak` to `sum`.
   - **Descending run:** count `down` steps, add `down` to `sum` for each step (starting from 1 upward for the bottom of the valley).
   - **Correction:** if `down > peak`, the peak child was under-counted → add `down - peak` to `sum`.
3. Return `sum`.

**Complexity:**
- **Time:** O(n) — single pass.
- **Space:** O(1) — no extra arrays.

---

### Approach 2: Better — Two-Pass with Optimized Right Array

**Idea:**  
Same logic as Approach 1 but eliminates the right array by doing the right-to-left pass on-the-fly with a single `right` variable. Build the `left[]` array in a forward pass, then do a backward pass computing the right count incrementally and summing `max(left[i], right)`.

**Algorithm:**
1. Build `left[]`: `left[i] = left[i-1] + 1` if rating increases, else `1`.
2. Traverse right to left: track `right` count. At each step, `curr = right + 1` if `ratings[i] > ratings[i+1]`, else `1`. Sum `max(left[i], curr)`.

**Complexity:**
- **Time:** O(n).
- **Space:** O(n) — only `left[]` array stored.

---

### Approach 1: Brute Force — Two Full Arrays

**Idea:**  
Build two arrays: `left[i]` counts candies needed considering only the left neighbor, `right[i]` counts considering only the right neighbor. Each child gets `max(left[i], right[i])` candies to satisfy both constraints.

**Algorithm:**
1. Forward pass: `left[i] = left[i-1] + 1` if `ratings[i] > ratings[i-1]`, else `1`.
2. Backward pass: `right[i] = right[i+1] + 1` if `ratings[i] > ratings[i+1]`, else `1`.
3. Sum up `max(left[i], right[i])` for all `i`.

**Complexity:**
- **Time:** O(n).
- **Space:** O(n) — two full arrays.
