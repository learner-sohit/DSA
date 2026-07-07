# Minimum Number of Platforms

**GeeksforGeeks Problem:** [https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1](https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1)

**Difficulty:** Medium

---

## Problem Description

Given arrival and departure times of trains at a railway station, find the **minimum number of platforms** required so that no train is kept waiting.

You are given two arrays `arr[]` and `dep[]` where `arr[i]` is the arrival time and `dep[i]` is the departure time of the `i`-th train.

---

## Examples

**Example 1:**

**Input:** `arr = [900, 940, 950, 1100, 1500, 1800]`, `dep = [910, 1200, 1120, 1130, 1900, 2000]`  
**Output:** `3`  
**Explanation:** At time 950, three trains are present simultaneously (arrived at 900, 940, 950). So at least 3 platforms are needed.

---

**Example 2:**

**Input:** `arr = [900, 1235, 1100]`, `dep = [1000, 1240, 1200]`  
**Output:** `1`  
**Explanation:** No two trains overlap, so a single platform suffices.

---

## Approach

---

### Approach 1: Greedy — Sort Arrivals & Departures + Two Pointers

**Idea:**  
Sort both `arr` and `dep` independently. Use two pointers — `i` for arrivals and `j` for departures. At each step, compare the next arrival time with the earliest pending departure:
- If the next train **arrives before or when** the earliest train departs (`arr[i] <= dep[j]`): a new platform is needed → increment `count` and advance `i`.
- Otherwise, a train has departed → a platform is freed → decrement `count` and advance `j`.

Track the maximum `count` seen at any point — that's the answer.

**Why sort independently?**  
We don't need to match arrivals to their own departures. We only need to know how many trains are simultaneously present, which is determined by comparing the next arrival against the earliest unpaired departure.

**Algorithm:**
1. Sort `arr` and `dep`.
2. Initialize `i = 1`, `j = 0`, `count = 1`, `maxCount = 1`.
3. While `i < n && j < n`:
   - If `arr[i] <= dep[j]` → `count++`, `i++`.
   - Else → `count--`, `j++`.
   - `maxCount = max(maxCount, count)`.
4. Return `maxCount`.

**Complexity:**
- **Time:** O(n log n) — sorting dominates.
- **Space:** O(1) — no extra space beyond the two pointers.
