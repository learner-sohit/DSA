# Count Subarrays With Even and Odd Ratio

## Problem Description

Given an integer array `nums` and two integers `a` and `b`, return the number of contiguous subarrays where the count of even numbers ($x$) and odd numbers ($y$) satisfies:

$$\frac{x}{y} \le \frac{a}{b} \quad \text{with } y > 0$$

To avoid floating-point division errors and zero division, this condition is cross-multiplied as:

$$\text{even} \times b \le \text{odd} \times a \quad \text{where } \text{odd} > 0$$

### Example

**Input:**
```text
nums = [1, 2, 3, 4], a = 1, b = 1
```

**Output:** `6`

---

## Approach: Nested Loop Subarray Traversal

> **Key Insight:** For every starting index `i`, we expand the subarray to ending index `j` from `i` to `n - 1`. At each step `j`, we increment `even` or `odd` count dynamically. If `odd > 0` and `even * b <= odd * a`, the current subarray `nums[i...j]` is valid, so we increment the answer counter `ans`.

### Algorithm

1. Initialize `ans = 0`.
2. Iterate `i` from `0` to `n - 1`:
   - Initialize `even = 0`, `odd = 0`.
   - Iterate `j` from `i` to `n - 1`:
     - If `nums[j]` is even, `even++`, else `odd++`.
     - Check if `odd > 0` and `even * b <= odd * a`.
     - If true, increment `ans`.
3. Return `ans`.

### Complexity

| | Complexity |
|---|---|
| **Time** | $O(N^2)$ — traversing all possible subarrays with nested loops |
| **Space** | $O(1)$ — constant auxiliary space |
