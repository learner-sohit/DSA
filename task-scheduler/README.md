# 621. Task Scheduler

**LeetCode Problem:** [https://leetcode.com/problems/task-scheduler/](https://leetcode.com/problems/task-scheduler/)

**Difficulty:** Medium

---

## Problem Description

You are given a characters array `tasks`, representing the tasks a CPU needs to do, where each letter of the alphabet represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer `n` that represents the **cooldown interval** between two **same** tasks (the same task must be separated by at least `n` intervals of other tasks or idle time).

Return the **least number of units of time** the CPU will take to finish all the given tasks.

---

## Examples

**Example 1:**

**Input:** `tasks = ["A","A","A","B","B","B"]`, `n = 2`  
**Output:** `8`  
**Explanation:** A → B → idle → A → B → idle → A → B. Total = 8 units.

---

**Example 2:**

**Input:** `tasks = ["A","A","A","B","B","B"]`, `n = 0`  
**Output:** `6`  
**Explanation:** No cooldown needed. A → B → A → B → A → B. Total = 6.

---

**Example 3:**

**Input:** `tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"]`, `n = 2`  
**Output:** `16`

---

## Approach

---

### Approach 1: Greedy — Max Heap with Cycle Simulation

**Idea:**  
At each CPU cycle of length `n+1`, greedily pick the **most frequent** remaining tasks to fill the slots. The most frequent tasks should always be scheduled first to minimize idle time. Use a Max Heap to always access the task with the highest remaining count in O(log k) time.

Each cycle processes up to `n+1` tasks (one slot per unit of time). If there are fewer distinct tasks than `n+1`, the remaining slots in the cycle are **idle**. The cycle ends early only when all tasks are completed (heap is empty), in which case no idle time is added.

**Algorithm:**
1. Count frequency of each task into `freq[26]`.
2. Add all non-zero frequencies to a **Max Heap**.
3. While heap is non-empty:
   - Set `cycle = n + 1` (size of one cooldown window).
   - Pull up to `cycle` tasks from the heap, decrement count, collect leftovers in `temp`.
   - Increment `time` for each task executed.
   - Push `temp` back into the heap.
   - If heap is now empty → done, break.
   - Otherwise → add remaining `cycle` slots as idle time.
4. Return `time`.

**Why `cycle = n + 1`?**  
Between two executions of the same task, at least `n` other units must pass. So a "window" of `n+1` units guarantees the cooldown is satisfied.

**Complexity:**
- **Time:** O(N × n) — in the worst case, many idle slots are added. N = number of tasks.
- **Space:** O(1) — heap has at most 26 entries (one per task type).
