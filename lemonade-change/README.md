# 860. Lemonade Change

**LeetCode Problem:** [https://leetcode.com/problems/lemonade-change/](https://leetcode.com/problems/lemonade-change/)

**Difficulty:** Easy

---

## Problem Description

At a lemonade stand, each lemonade costs `$5`. Customers pay with either a `$5`, `$10`, or `$20` bill. You must give **exact change** to every customer. You start with no change in hand.

Given an integer array `bills` where `bills[i]` is the bill the `i`-th customer pays, return `true` if you can provide every customer with correct change, or `false` otherwise.

---

## Examples

**Example 1:**

**Input:** `bills = [5,5,5,10,20]`  
**Output:** `true`  
**Explanation:** First 3 customers pay $5 (no change needed). 4th pays $10 → give back $5. 5th pays $20 → give back $10 + $5.

---

**Example 2:**

**Input:** `bills = [5,5,10,10,20]`  
**Output:** `false`  
**Explanation:** After the first two $5 bills and first $10 bill, we have one $5 and one $10. The second $10 bill requires a $5 in change, but we only have a $10 — so we can't make change for the second $20.

---

## Approach

---

### Approach 1: Greedy — Track $5 and $10 Bills

**Idea:**  
We only ever need to track two denominations: `$5` and `$10` (we never give back a `$20`). For each bill:
- **$5:** No change needed — just collect it.
- **$10:** Give back `$5` change. Fail if none available.
- **$20:** Need to give `$15` change. Two options:
  - Give `$10 + $5` ← **preferred** (greedy: saves $5 bills which are more versatile)
  - Give `$5 + $5 + $5` ← fallback

The key greedy decision for `$20` bills: always prefer giving a `$10 + $5` over three `$5` bills, because `$5` bills can serve as change for both `$10` and `$20` payments while `$10` bills can only be used for `$20` payments.

**Algorithm:**
1. Maintain counters `five` and `ten`.
2. For each bill:
   - `$5`: `five++`
   - `$10`: if `five > 0` → `five--, ten++`; else return `false`.
   - `$20`: if `ten > 0 && five > 0` → `ten--, five--`; else if `five >= 3` → `five -= 3`; else return `false`.
3. Return `true` after processing all bills.

**Complexity:**
- **Time:** O(n) — single pass through the bills array.
- **Space:** O(1) — only two counters used.
