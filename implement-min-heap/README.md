# Implement Min Heap

**GeeksforGeeks Problem:** [https://www.geeksforgeeks.org/problems/implementing-heap/1](https://www.geeksforgeeks.org/problems/implementing-heap/1)

**Difficulty:** Easy

---

## Problem Description

Implement a **Min Heap** data structure from scratch using an `ArrayList`. Support the following operations:

| Operation | Description |
|---|---|
| `push(x)` | Insert element `x` into the heap |
| `pop()` | Remove the minimum (top) element |
| `peek()` | Return the minimum element without removing it |
| `size()` | Return the number of elements in the heap |

A Min Heap is a complete binary tree where every parent node is **less than or equal to** its children. It is stored as a 0-indexed array where:
- Parent of node `i` → `(i - 1) / 2`
- Left child of node `i` → `2 * i + 1`
- Right child of node `i` → `2 * i + 2`

---

## Implementation

---

### push(x) — Bubble Up (Heapify Up)

Insert the new element at the end of the array, then repeatedly swap it with its parent while it is smaller than its parent, until the heap property is restored.

```
heap = [1, 3, 5] → push(2) → heap = [1, 3, 5, 2]
                             → 2 < parent(3) → swap → [1, 2, 5, 3]
                             → 2 > parent(1) → stop
```

**Time:** O(log n)

---

### pop() — Heapify Down

Replace the root (minimum) with the last element, remove the last, then repeatedly swap the root downward with its smaller child until the heap property is restored.

```
heap = [1, 2, 5, 3] → pop() → [2, 5, 3] (after moving last to root)
                             → 2 < both children → heap valid
```

**Time:** O(log n)

---

### peek()

Return `heap.get(0)`. Return `-1` if empty.

**Time:** O(1)

---

### size()

Return `heap.size()`.

**Time:** O(1)

---

## Complexity Summary

| Operation | Time | Space |
|---|---|---|
| `push(x)` | O(log n) | O(1) |
| `pop()` | O(log n) | O(1) |
| `peek()` | O(1) | O(1) |
| `size()` | O(1) | O(1) |
| Overall Space | — | O(n) |
