# 678. Valid Parenthesis String

**LeetCode Problem:** [https://leetcode.com/problems/valid-parenthesis-string/](https://leetcode.com/problems/valid-parenthesis-string/)

**Difficulty:** Medium

---

## Problem Description

Given a string `s` containing only three types of characters: `'('`, `')'`, and `'*'`, return `true` if `s` is valid.

The following rules define a valid string:
- Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
- Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
- Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
- `'*'` could be treated as a single right parenthesis `')'`, a single left parenthesis `'('`, or an empty string `""`.

---

## Examples

**Example 1:**

**Input:** `s = "()"`  
**Output:** `true`

---

**Example 2:**

**Input:** `s = "(*)"`  
**Output:** `true`

---

**Example 3:**

**Input:** `s = "(*))"`  
**Output:** `true`

---

## Approaches

---

### Approach 2: Optimal — Greedy with Low/High Range (Active)

**Idea:**  
Instead of exploring all possibilities for `*`, track the **range** of possible open bracket counts at each step:
- `low` = minimum possible number of unmatched `(` (treating `*` as `)` or empty).
- `high` = maximum possible number of unmatched `(` (treating `*` as `(`).

At any point, if `high < 0`, even the most optimistic interpretation has too many `)` — return `false`. Clamp `low` at 0 since the count can't go negative. At the end, if `low == 0`, there's a valid interpretation that perfectly balances the string.

**Algorithm:**
1. Initialize `low = 0`, `high = 0`.
2. For each character:
   - `'('`: both `low++` and `high++`.
   - `')'`: both `low--` and `high--`.
   - `'*'`: `low--` (treat as `)`), `high++` (treat as `(`).
3. Clamp `low = max(low, 0)` after each step.
4. If `high < 0` at any point → return `false`.
5. Return `low == 0`.

**Complexity:**
- **Time:** O(n) — single pass.
- **Space:** O(1) — only two counters.

---

### Approach 1: Brute Force — Recursion (Try All `*` Options)

**Idea:**  
Recursively process each character. For `*`, branch into three recursive calls — treating it as `(`, `)`, or empty string. Return `true` if any branch leads to a valid string (i.e., `count == 0` at the end).

**Algorithm:**
1. `helper(s, idx, count)`: `count` tracks unmatched open brackets.
2. If `count < 0` → invalid (too many `)`), return `false`.
3. If `idx == s.length()` → return `count == 0`.
4. For `(`: recurse with `count + 1`.
5. For `)`: recurse with `count - 1`.
6. For `*`: try all three — `count+1`, `count-1`, `count`.

**Complexity:**
- **Time:** O(3^n) — each `*` triples the branches.
- **Space:** O(n) — recursion call stack depth.
