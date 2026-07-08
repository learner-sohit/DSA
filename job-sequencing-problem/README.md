# Job Sequencing Problem

**GeeksforGeeks Problem:** [https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1](https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1)

**Difficulty:** Medium

---

## Problem Description

You are given two arrays `deadline[]` and `profit[]` for `n` jobs. Each job takes **exactly 1 unit of time** to complete and must be done on or before its `deadline`. Only one job can be scheduled at a time. Your task is to find the **maximum number of jobs** that can be done and the **maximum profit** earned.

Return an `ArrayList` of two integers: `[jobCount, maxProfit]`.

---

## Examples

**Example 1:**

**Input:** `deadline = [4, 1, 1, 1]`, `profit = [20, 10, 40, 30]`  
**Output:** `[2, 60]`  
**Explanation:** Job 3 (profit 40, deadline 1) is scheduled at time slot 1. Job 1 (profit 20, deadline 4) is scheduled at time slot 4. Total = 2 jobs, profit = 60.

---

**Example 2:**

**Input:** `deadline = [2, 1, 2, 1, 1]`, `profit = [100, 19, 27, 25, 15]`  
**Output:** `[2, 127]`  
**Explanation:** Job 1 (profit 100) at slot 2, Job 4 (profit 27) at slot 1. Total = 2 jobs, profit = 127.

---

## Approach

---

### Approach 1: Greedy — Sort by Profit + Slot Scheduling

**Idea:**  
Always prioritize the job with the **highest profit**. For each job (in descending profit order), try to assign it to the **latest available time slot** within its deadline. Assigning it as late as possible keeps earlier slots free for future lower-profit jobs that may have tighter deadlines.

**Algorithm:**
1. Pair each job's `deadline[i]` and `profit[i]` into a `Jobs` object.
2. Find `maxDeadline` to size the slot array.
3. Sort jobs in **descending order of profit**.
4. Maintain a `slot[]` boolean array (size `maxDeadline + 1`) to track occupied time slots.
5. For each job:
   - Starting from its `deadline`, find the latest available slot (`slot[j] == false`).
   - If found: mark it, increment `jobCount`, add to `maxProfit`.
   - If no slot available before deadline 1: skip the job.
6. Return `[jobCount, maxProfit]`.

**Complexity:**
- **Time:** O(n log n) for sorting + O(n × maxDeadline) for slot assignment.
- **Space:** O(maxDeadline) — slot tracking array.
