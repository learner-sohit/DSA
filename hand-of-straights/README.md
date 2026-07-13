# 846. Hand of Straights

**LeetCode Problem:** [https://leetcode.com/problems/hand-of-straights/](https://leetcode.com/problems/hand-of-straights/)

**Difficulty:** Medium

---

## Problem Description

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size `groupSize`, and consists of `groupSize` **consecutive** cards.

Given an integer array `hand` where `hand[i]` is the value written on the `i`th card and an integer `groupSize`, return `true` if she can rearrange the cards, or `false` otherwise.

---

## Examples

**Example 1:**

**Input:** `hand = [1,2,3,6,2,3,4,7,8]`, `groupSize = 3`  
**Output:** `true`  
**Explanation:** Alice's hand can be rearranged as `[1,2,3]`, `[2,3,4]`, `[6,7,8]`.

---

**Example 2:**

**Input:** `hand = [1,2,3,4,5]`, `groupSize = 4`  
**Output:** `false`  
**Explanation:** Alice's hand can't be rearranged into groups of 4.

---

## Approach

---

### Approach 1: Greedy — Sort + HashMap Frequency Count

**Idea:**  
Sort the hand so cards are processed in ascending order. Use a `HashMap` to track how many of each card remain. Iterate through the sorted hand — if a card still has remaining count, try to form a group of `groupSize` consecutive cards starting from it. Decrement each card's count as it is used. If any required consecutive card has count 0, it's impossible — return `false`.

**Why sort first?**  
Sorting ensures we always start building groups from the smallest available card. This greedy choice is optimal: there is no reason to delay using the smallest card for a group, since it can only be the start of a consecutive sequence (not the middle or end of any group starting earlier).

**Algorithm:**
1. Early exit: if `hand.length % groupSize != 0`, return `false`.
2. Sort `hand`.
3. Build `map`: frequency count of each card.
4. For each `num` in sorted `hand`:
   - If `map.get(num) == 0`: card already used, skip.
   - Otherwise: try to form a group `[num, num+1, ..., num+groupSize-1]`.
   - For each `card = num+i`: if count is 0 → return `false`; else decrement count.
5. Return `true`.

**Complexity:**
- **Time:** O(n log n) — sorting dominates.
- **Space:** O(n) — HashMap stores at most `n` distinct entries.
