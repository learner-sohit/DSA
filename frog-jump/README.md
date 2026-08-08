# Frog Jump

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/dsa/minimum-cost-for-hopping-frog-to-reach-stair-n/)

## Problem Description

You are given an integer array `height[]` where `height[i]` represents the height of the `i`-th stair. A frog starts from the first stair and wants to reach the last stair.

From any stair `i`, the frog can jump to stair `i + 1` or stair `i + 2`. The cost of a jump is the absolute difference in height between the two stairs.

Return the **minimum total cost** required for the frog to reach the last stair.

### Example

**Input:** `height = [30, 20, 50, 10, 40]`  
**Output:** `30`

**Explanation:** Jump from stair 0 to 2, then from stair 2 to 4:

- `|50 - 30| = 20`
- `|40 - 50| = 10`
- Total cost = `20 + 10 = 30`

## Explanation

### Top-Down Dynamic Programming (Memoization)

To reach stair `n`, the frog must arrive from either stair `n - 1` (one-step jump) or stair `n - 2` (two-step jump). The minimum cost follows a recurrence similar to climbing stairs, but each transition adds the height-difference cost.

1. Create a `dp` array of size `n + 1` and fill it with `-1`.
2. Call `solve(n - 1, height, dp)` to compute the minimum cost to reach the last stair.
3. Base case: cost to reach stair `0` is `0`.
4. If `dp[n]` is already computed, return the stored value.
5. Compute the one-step cost:
   - `n1 = solve(n - 1, height, dp) + |height[n] - height[n - 1]|`
6. Compute the two-step cost when `n > 1`:
   - `n2 = solve(n - 2, height, dp) + |height[n] - height[n - 2]|`
7. Store and return `min(n1, n2)`.

- **Time Complexity:** O(n), each stair index is solved once.
- **Space Complexity:** O(n), for the memoization array and recursion stack.
