/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

///////Optimal approcah//////////
var longestOnes = function (nums, k) {
  let maxlen = 0,
    left = 0,
    right = 0,
    zeros = 0;

  while (right < nums.length) {
    if (nums[right] === 0) zeros++;
    if (zeros > k) {
      if (nums[left] === 0) zeros--;
      left++;
    }
    maxlen = Math.max(maxlen, right - left + 1);
    right++;
  }
  return maxlen;
};

/*
 //////Brute force solution/////
var longestOnes_bruteForce = function(nums, k) {
    let maxlen = 0;
    for(let i=0;i<nums.length;i++) {
        let zeros = 0;
        for(let j=i;j<nums.length;j++) {
            if(nums[j] === 0) zeros++;
            if(zeros > k) break;
            else {
                let len = j-i+1;
                maxlen = Math.max(len,maxlen);
            }
        }
    }
    return maxlen;
};
*/
