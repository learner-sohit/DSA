/**
 * @param {number[]} nums
 * @param {number} goal
 * @return {number}
 */

/////////optmimal soluttion////////
var numSubarraysWithSum = function (nums, goal) {
  return countSubArray(nums, goal) - countSubArray(nums, goal - 1);
};

function countSubArray(nums, goal) {
  if (goal < 0) return 0;
  let count = 0,
    sum = 0,
    left = 0,
    right = 0;

  while (right < nums.length) {
    sum += nums[right];
    while (sum > goal) {
      sum -= nums[left];
      left++;
    }
    count += right - left + 1;
    right++;
  }
  return count;
}

/*
 ////////Brute force Approcah/////////
var numSubarraysWithSum_bruteForce = function(nums, goal) {
    let max = 0
    for(let i=0;i<nums.length;i++) {
        let sum = 0;
        for(let j=i;j<nums.length;j++) {
            sum += nums[j];
            if(sum > goal) {
                break;
            }
            if(sum === goal) max += 1;
        }
    }
    return max;
    
};
*/
