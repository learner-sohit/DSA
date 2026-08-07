# 13. Roman to Integer

[Link to Problem on LeetCode](https://leetcode.com/problems/roman-to-integer/)

## Problem Description

Roman numerals use seven symbols: `I`, `V`, `X`, `L`, `C`, `D`, and `M`, representing `1`, `5`, `10`, `50`, `100`, `500`, and `1000` respectively.

Normally symbols are written from largest to smallest and their values are added. When a smaller symbol appears before a larger symbol, its value is subtracted instead. Convert a valid Roman numeral string into an integer.

### Example

**Input:**
```
s = "MCMXCIV"
```

**Output:** `1994`

**Explanation:** `M = 1000`, `CM = 900`, `XC = 90`, and `IV = 4`.

---

## Approach: Compare Adjacent Symbols

Map each Roman symbol to its integer value. While scanning the string, compare the current symbol with the next one. A current value smaller than the next is part of a subtractive pair, so subtract it; otherwise add it.

### Algorithm

1. Store the value of each Roman symbol in a map.
2. Iterate through the input string.
3. Read the current value and the next value, using `0` when there is no next symbol.
4. Subtract the current value when it is smaller than the next; otherwise add it.
5. Return the accumulated result.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N) |
| **Space** | O(1) |
