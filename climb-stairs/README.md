# 70. Climbing Stairs

[Link to Problem on LeetCode](https://leetcode.com/problems/climbing-stairs/)

## Problem Description

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

### Example

**Input:** `n = 3`  
**Output:** `3`

**Explanation:** There are three ways to climb to the top:

1. `1` step + `1` step + `1` step
2. `1` step + `2` steps
3. `2` steps + `1` step

## Explanation

### Top-Down Dynamic Programming (Memoization)

This approach uses recursion with memoization. To reach step `n`, you can arrive from step `n - 1` (one step) or step `n - 2` (two steps), so the number of ways follows the same recurrence as Fibonacci numbers.

1. Create a `dp` array of size `n + 1` and fill it with `-1`.
2. Define a recursive helper `solve(n, dp)`.
3. Return `n` directly for base cases `n <= 2`.
4. If `dp[n]` is already computed, return the stored value.
5. Otherwise, compute `solve(n - 2, dp) + solve(n - 1, dp)`, store it in `dp[n]`, and return it.

- **Time Complexity:** O(n), each state from `1` to `n` is computed once.
- **Space Complexity:** O(n), for the memoization array and recursion stack.

### Iterative Bottom-Up (Space Optimized)

This approach builds the answer from the base cases without recursion. Only the last two values are needed at each step.

1. Return `n` directly when `n <= 2`.
2. Initialize:
   - `prev2 = 1` (ways to reach step 1).
   - `prev1 = 2` (ways to reach step 2).
3. Loop from `3` to `n`.
4. Compute `curr = prev2 + prev1`.
5. Shift `prev2` and `prev1` forward.
6. Return `prev1`, which holds the answer for step `n` after the loop.

- **Time Complexity:** O(n), one loop runs from `3` to `n`.
- **Space Complexity:** O(1), only a few variables are used.

The file keeps the iterative bottom-up approach as the active submitted solution and top-down memoization as a commented alternative.
