# 1423. Maximum Points You Can Obtain from Cards

[Link to Problem on LeetCode](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)

## Problem Description

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array `cardPoints`.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly `k` cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array `cardPoints` and the integer `k`, return the maximum score you can obtain.

## Explanation

### Optimal Approach (Sliding Window)

This problem can be solved efficiently using a sliding window technique. Instead of thinking about which `k` cards to _take_, we can reframe the problem as finding a subarray of size `n - k` with the _minimum_ sum. The total sum of all points minus this minimum sum will give us the maximum score from the `k` cards we take from the ends.

However, the provided solution uses a more direct sliding window approach. It calculates the sum of different combinations of `k` cards taken from the ends.

The algorithm works as follows:

1.  First, calculate an initial sum by taking all `k` cards from the left side (the beginning of the array). This `leftSum` is our initial `maxPoints`.
2.  Then, iterate `k` times to simulate moving one card at a time from the left pile to the right pile. In each iteration:
    - Remove the rightmost card from the current left selection (`leftSum -= cardPoints[k-i-1]`).
    - Add the rightmost available card from the end of the main array (`rightSum += cardPoints[n-i-1]`).
    - The current total is `leftSum + rightSum`. Update `maxPoints` if this new total is greater.
3.  After iterating through all `k` possible swaps, `maxPoints` will hold the maximum possible score.

### Complexity

- **Time Complexity:** O(k) - We have two separate loops that each run `k` times.
- **Space Complexity:** O(1) - We only use a few variables to store the sums and pointers, so the space is constant.
