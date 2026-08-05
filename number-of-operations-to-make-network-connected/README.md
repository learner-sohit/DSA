# 1319. Number of Operations to Make Network Connected

[Link to Problem on LeetCode](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)

## Problem Description

There are `n` computers numbered from `0` to `n - 1`, connected by cables in `connections`. A cable can connect two directly connected computers, and a network is connected when every computer can reach every other computer directly or indirectly.

You may remove a cable between two directly connected computers and reconnect it between two disconnected computers. Return the minimum number of such operations needed to connect the network, or `-1` when it is impossible.

### Example

**Input:**
```
n = 4
connections = [[0,1], [0,2], [1,2]]
```

**Output:** `1`

**Explanation:** The cable between computers `1` and `2` is redundant because they are already connected through `0`. Move it to connect computer `3` to the network.

---

## Approach: Union-Find

Use a disjoint-set structure to group connected computers. When a cable connects computers already in the same group, it is redundant and can be reused. After processing every cable, a network with `components` groups needs exactly `components - 1` cables to connect all groups.

### Algorithm

1. Initialize a disjoint-set structure with one component per computer.
2. Process each cable:
   - If both computers already have the same representative, increment the redundant cable count.
   - Otherwise, union their components by size.
3. Count the remaining component representatives.
4. Return `components - 1` if there are enough redundant cables; otherwise return `-1`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(E * alpha(N)) |
| **Space** | O(N) |
