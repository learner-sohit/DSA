/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let maxLen = 0;

    for(let i=0;i<s.length;i++) {
        let hash = [];
        for(let j=i;j<s.length;j++) {
            if(hash[s[j]] == 1) break;
            maxLen = Math.max(maxLen,j-i+1);
            hash[s[j]] = 1;
        } 
    }
    return maxLen;
    
};
