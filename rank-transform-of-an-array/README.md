# 1331. Rank Transform of an Array

**LeetCode Problem:** [https://leetcode.com/problems/rank-transform-of-an-array/](https://leetcode.com/problems/rank-transform-of-an-array/)

**Difficulty:** Easy

---

## Problem Description

Given an integer array `arr`, replace each element with its **rank**. The rank represents how large the element is, with the following rules:

- Rank is an integer starting from 1.
- The larger the element, the larger the rank.
- If two elements are equal, their rank must be the same.
- Rank should be as small as possible.

---

## Examples

**Example 1:**

**Input:** `arr = [40,10,20,30]`  
**Output:** `[4,1,2,3]`  
**Explanation:** 10 is the smallest → rank 1, 20 → rank 2, 30 → rank 3, 40 → rank 4.

---

**Example 2:**

**Input:** `arr = [100,100,100]`  
**Output:** `[1,1,1]`  
**Explanation:** All equal → all get rank 1.

---

**Example 3:**

**Input:** `arr = [37,12,28,9,100,56,80,5,12]`  
**Output:** `[5,3,4,2,8,6,7,1,3]`

---

## Approaches

---

### Approach 2: Optimal — Sort + HashMap for Rank Lookup (Active)

**Idea:**  
Clone and sort the array to get elements in ascending order. Walk through the sorted array and assign each unique value an incrementing rank, stored in a `HashMap`. Then replace each element in the original array by looking up its rank in the map. Reuse the `sorted` array as the output to avoid an extra allocation.

**Algorithm:**
1. Clone `arr` into `sorted` and sort it.
2. Walk `sorted` left to right: for each element not yet in `map`, assign `rank++`.
3. Walk original `arr`: `sorted[i] = map.get(arr[i])`.
4. Return `sorted`.

**Why skip duplicates in step 2?**  
`map.containsKey()` ensures equal elements always get the same rank — `rank` only increments for new unique values.

**Complexity:**
- **Time:** O(n log n) — dominated by sorting.
- **Space:** O(n) — sorted clone + HashMap.

---

### Approach 1: Brute Force — Linear Scan for Each Element

**Idea:**  
For each element in `arr`, scan the sorted array left to right to find its rank. The rank starts at 1 and increments each time a new distinct value is encountered during the scan.

**Algorithm:**
1. Clone and sort into `sorted`.
2. For each `arr[i]`: scan `sorted` — increment `rank` at each distinct new value, stop when `sorted[j] == arr[i]`.
3. Store rank in `ans[i]`.

**Complexity:**
- **Time:** O(n²) — outer loop × inner scan for each element.
- **Space:** O(n) — sorted clone + answer array.
