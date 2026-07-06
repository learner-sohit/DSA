# N Meetings in One Room

**GeeksforGeeks Problem:** [https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1](https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1)

**Difficulty:** Easy

---

## Problem Description

You are given `n` meetings with their `start[]` and `finish[]` times. Only **one meeting can be held at a time** in a single room. Find the **maximum number of meetings** that can be accommodated and return their **1-based indices** in sorted order.

If two meetings end at the same time, the one with the **smaller index** is preferred.

---

## Examples

**Example 1:**

**Input:** `s = [1, 3, 0, 5, 8, 5]`, `f = [2, 4, 6, 7, 9, 9]`  
**Output:** `[1, 2, 4, 5]`  
**Explanation:** Meetings at indices 1, 2, 4, and 5 can be accommodated without overlap. Total = 4 meetings.

---

**Example 2:**

**Input:** `s = [10, 12, 20]`, `f = [20, 25, 30]`  
**Output:** `[1]`  
**Explanation:** Only the first meeting fits without any conflict (all start times overlap after it ends at 20).

---

## Approach

---

### Approach 1: Greedy — Sort by End Time

**Idea:**  
This is the classic **Activity Selection Problem**. The greedy insight is: always pick the meeting that **ends the earliest** among those that don't conflict with the last selected meeting. This frees up the room as soon as possible, maximizing the number of future meetings that can fit.

**Algorithm:**
1. Create a `MeetInfo` array storing each meeting's `start`, `end`, and 1-based `idx`.
2. Sort by `end` time; break ties by original `idx` (prefer smaller index).
3. Always select the first meeting. Track `endTime` of the last selected meeting.
4. For each subsequent meeting: if `start > endTime`, select it and update `endTime`.
5. Sort the result list by index and return.

**Why `start > endTime` (strict)?**  
A meeting can only start after the previous one has completely finished — two meetings cannot share the same end/start time simultaneously in one room.

**Complexity:**
- **Time:** O(n log n) — sorting dominates.
- **Space:** O(n) — `MeetInfo` array and result list.
