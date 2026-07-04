# Fractional Knapsack

**GeeksforGeeks Problem:** [https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1](https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1)

**Difficulty:** Medium

---

## Problem Description

Given two arrays `val[]` and `wt[]` representing the values and weights of `n` items, and an integer `capacity` representing the maximum weight a knapsack can hold, determine the **maximum total value** that can be put in the knapsack.

Unlike the 0/1 Knapsack problem, you can take **fractions** of an item — you do not have to take the whole item.

---

## Examples

**Example 1:**

**Input:** `val[] = [60, 100, 120]`, `wt[] = [10, 20, 30]`, `capacity = 50`  
**Output:** `240.0`  
**Explanation:** Take all of item 1 (60), all of item 2 (100), and 2/3 of item 3 (80). Total = `240`.

---

**Example 2:**

**Input:** `val[] = [60, 100]`, `wt[] = [10, 20]`, `capacity = 50`  
**Output:** `160.0`  
**Explanation:** Both items fit entirely. Total = `60 + 100 = 160`.

---

## Approach

---

### Approach 1: Greedy — Sort by Value/Weight Ratio

**Idea:**  
The key greedy insight is: always pick the item (or fraction of an item) that gives the **highest value per unit weight** first. Sorting items by their `val/wt` ratio in descending order and greedily filling the knapsack maximizes the total value.

**Algorithm:**
1. Create an `Item` array pairing each `val[i]` with `wt[i]`.
2. Sort the array in descending order of `val / wt` ratio.
3. Iterate through sorted items:
   - If the item fits entirely (`wt <= capacity`): take it fully, add its value, reduce capacity.
   - Otherwise: take the fraction that fits (`(val/wt) * remaining capacity`), add to result, and stop.
4. Return the accumulated `maxValue`.

**Complexity:**
- **Time:** O(n log n) — sorting dominates.
- **Space:** O(n) — auxiliary `Item` array.
