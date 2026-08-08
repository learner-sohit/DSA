# 509. Fibonacci Number

[Link to Problem on LeetCode](https://leetcode.com/problems/fibonacci-number/)

## Problem Description

The **Fibonacci numbers**, commonly denoted `F(n)`, form a sequence called the **Fibonacci sequence**, such that each number is the sum of the two preceding ones, starting from `0` and `1`. That is:

```text
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1
```

Given `n`, calculate `F(n)`.

### Example

**Input:** `n = 4`  
**Output:** `3`

**Explanation:** `F(4) = F(3) + F(2) = 2 + 1 = 3`

## Explanation

### Top-Down Dynamic Programming

The brute-force recursive solution recalculates the same Fibonacci values many times. This solution keeps the recursive structure, but stores every computed value in a `dp` array so each state is solved once.

1. Create a `dp` array of size `n + 1` and fill it with `-1`.
2. Use recursion to compute `F(n)`.
3. Return `n` directly for the base cases `n == 0` and `n == 1`.
4. Before solving a state, check whether `dp[n]` already has an answer.
5. Store `solve(n - 2, dp) + solve(n - 1, dp)` in `dp[n]` and return it.

The file also keeps the brute-force recursion and iterative bottom-up approach as commented alternatives.

- **Time Complexity:** O(n), each Fibonacci state from `0` to `n` is computed once.
- **Space Complexity:** O(n), for the memoization array and recursion stack.
