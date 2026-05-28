/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
//////optimal solution////////
var numberOfSubarrays = function (nums, k) {
  return countSubArray(nums, k) - countSubArray(nums, k - 1);
};

function countSubArray(nums, k) {
  if (k < 0) return 0;
  let left = 0;
  let right = 0;
  let count = 0;
  let oddCount = 0;

  while (right < nums.length) {
    if (nums[right] % 2 !== 0) oddCount++;
    while (oddCount > k) {
      if (nums[left] % 2 !== 0) oddCount--;
      left++;
    }
    count += right - left + 1;
    right++;
  }
  return count;
}

/*
 //////Brute force solution//////////
var numberOfSubarrays_bruteForce = function(nums, k) {
    let count = 0;

    for(let i=0;i<nums.length;i++) {
        let oddCount = 0;
        for(let j=i;j<nums.length;j++) {
            if(nums[j] %2 !== 0) oddCount++;
            if(oddCount === k) count++;
            if (oddCount > k) break;
        }
    }
    return count;
    
};
*/
