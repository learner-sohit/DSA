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

### Iterative Bottom-Up

Instead of using recursion, this solution builds the Fibonacci sequence iteratively with two variables.

1. Initialize `a = 0` and `b = 1`, representing `F(0)` and `F(1)`.
2. Handle base cases: return `a` when `n == 0`, return `b` when `n == 1`.
3. Loop from `i = 2` to `n`:
   - Compute `sum = a + b`.
   - Shift the window forward: `a = b`, then `b = sum`.
4. After the loop, `sum` holds `F(n)`.

- **Time Complexity:** O(n), one iteration per index from 2 to n.
- **Space Complexity:** O(1), only a constant number of variables are used.
