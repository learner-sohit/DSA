# Maximum Pair Strength

## Problem Description

Given an integer array `nums`, find the **maximum strength** among all possible pair of indices `(i, j)` where `i != j`.

The **strength** of a pair `(nums[i], nums[j])` is defined as:

$$\text{Strength} = \frac{\text{nums}[i] \times \text{nums}[j]}{\text{gcd}(\text{nums}[i], \text{nums}[j])^2}$$

### Example

**Input:**
```text
nums = [4, 6, 8]
```

**Output:** `12`

**Explanation:**
- Pair `(4, 6)`: $\text{gcd}(4, 6) = 2$. Strength = $(4 \times 6) / 2^2 = 24 / 4 = 6$.
- Pair `(4, 8)`: $\text{gcd}(4, 8) = 4$. Strength = $(4 \times 8) / 4^2 = 32 / 16 = 2$.
- Pair `(6, 8)`: $\text{gcd}(6, 8) = 2$. Strength = $(6 \times 8) / 2^2 = 48 / 4 = 12$.

The maximum strength among all pairs is `12`.

---

## Approach: Brute Force Pairwise Comparison

> **Key Insight:** The formula $\frac{a \times b}{\text{gcd}(a, b)^2}$ is equivalent to $\frac{a}{\text{gcd}(a, b)} \times \frac{b}{\text{gcd}(a, b)}$. By iterating through all unique pairs `(i, j)` where `0 <= i < j < N`, we compute the GCD using Euclidean algorithm, calculate the pair strength using $64$-bit integer multiplication (`1L * nums[i] * nums[j]`) to avoid integer overflow, and track the maximum strength seen so far.

### Algorithm

1. Initialize `ans = 0`.
2. Loop `i` from `0` to `N - 2`.
3. Loop `j` from `i + 1` to `N - 1`.
4. Compute `hcf = gcd(nums[i], nums[j])`.
5. Calculate `strength = (1L * nums[i] * nums[j]) / (hcf * hcf)`.
6. Update `ans = max(ans, strength)`.
7. Return `ans`.

### Complexity

| | Complexity |
|---|---|
| **Time** | $O(N^2 \log(\min(A, B)))$ — iterating over $O(N^2)$ pairs and performing Euclidean GCD in logarithmic time |
| **Space** | $O(1)$ — constant auxiliary space |
