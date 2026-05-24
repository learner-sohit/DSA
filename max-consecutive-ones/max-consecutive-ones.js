/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
    let max = 0;
    let len = 0;
    
    for(let i=0;i<nums.length;i++) {
        if(nums[i]===0){
            len = 0;
        }else {
            len++;
            max = Math.max(len, max);
        }
    }
    return max;
};
