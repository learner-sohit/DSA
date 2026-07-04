# 455. Assign Cookies

**LeetCode Problem:** [https://leetcode.com/problems/assign-cookies/](https://leetcode.com/problems/assign-cookies/)

**Difficulty:** Easy

---

## Problem Description

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child **at most one cookie**.

Each child `i` has a greed factor `g[i]`, which is the minimum size of a cookie that the child will be content with. Each cookie `j` has a size `s[j]`.

If `s[j] >= g[i]`, we can assign cookie `j` to child `i` and the child will be content. Your goal is to **maximize the number of content children** and return this maximum number.

---

## Examples

**Example 1:**

**Input:** `g = [1,2,3]`, `s = [1,1]`  
**Output:** `1`  
**Explanation:** You have 3 children and 2 cookies. The greed factors are `[1,2,3]`. Only one cookie can satisfy child with greed `1`. The other child with greed `2` or `3` cannot be satisfied. Answer: `1`.

---

**Example 2:**

**Input:** `g = [1,2]`, `s = [1,2,3]`  
**Output:** `2`  
**Explanation:** You have 2 children and 3 cookies. The greed factors are `[1,2]`. Both children can be satisfied. Answer: `2`.

---

## Approach

---

### Approach 1: Greedy — Sort + Two Pointers

**Idea:**  
Sort both arrays. Then use two pointers — one for children (`i`) and one for cookies (`j`). Always try to satisfy the least greedy unsatisfied child with the smallest available cookie. If the current cookie is big enough, move to the next child. Always advance the cookie pointer regardless.

This greedy strategy works because satisfying the least greedy child first with the smallest fitting cookie leaves larger cookies available for greedier children.

**Algorithm:**
1. Sort `g` (greed factors) and `s` (cookie sizes).
2. Initialize `i = 0` (child pointer), `j = 0` (cookie pointer).
3. While both pointers are in bounds:
   - If `s[j] >= g[i]`: child `i` is satisfied → increment `i`.
   - Always increment `j` (move to the next cookie).
4. Return `i` (number of content children).

**Complexity:**
- **Time:** O(n log n + m log m) — sorting both arrays, where `n = g.length` and `m = s.length`.
- **Space:** O(1) — sorting in place, no extra space used.
