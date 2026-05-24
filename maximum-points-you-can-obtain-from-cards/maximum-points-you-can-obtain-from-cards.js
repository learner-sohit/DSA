/**
 * @param {number[]} cardPoints
 * @param {number} k
 * @return {number}
 */
var maxScore = function (cardPoints, k) {
  const n = cardPoints.length;
  let maxPoints = 0,
    leftSum = 0,
    rightSum = 0;

  for (let i = 0; i < k; i++) {
    leftSum += cardPoints[i];
  }
  maxPoints = Math.max(maxPoints, leftSum + rightSum);

  for (let i = 0; i < k; i++) {
    leftSum -= cardPoints[k - i - 1];
    rightSum += cardPoints[n - i - 1];
    maxPoints = Math.max(maxPoints, leftSum + rightSum);
  }
  return maxPoints;
};
