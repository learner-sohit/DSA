# 3731. Find Missing Elements

[Link to Problem on LeetCode](https://leetcode.com/problems/find-missing-elements/)

## Problem Description

You are given an integer array `nums` containing unique integers. The array originally contained every integer in a continuous range, but some integers may be missing. The smallest and largest values from the original range are still present.

Return a sorted list of every missing integer between the smallest and largest values in `nums`.

### Example

**Input:**
```
nums = [1, 4, 2, 5]
```

**Output:** `[3]`

**Explanation:** The range is from `1` to `5`, and `3` is the only missing value.

---

## Approach 1: Brute Force

Find the smallest and largest values. For every integer in that inclusive range, linearly scan `nums` to check whether it exists. Add values that are not found to the result.

### Algorithm

1. Find the minimum and maximum values in `nums`.
2. Iterate from `min` through `max`.
3. For each value, scan `nums` to determine whether it is present.
4. Add absent values to the result list.
5. Return the result.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N * R), where `R = max - min + 1` |
| **Space** | O(1), excluding the result list |

## Approach 2: HashSet

Store every array value in a `HashSet` while finding the range boundaries. Then scan the values strictly between the minimum and maximum, adding those absent from the set.

### Algorithm

1. Find the minimum and maximum values and insert each value into a `HashSet`.
2. Iterate from `min + 1` to `max - 1`.
3. Add each value that is not in the set to the result list.
4. Return the result.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N + R), where `R = max - min + 1` |
| **Space** | O(N) |
