/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */

///// Optimal Approcah---2. ///////
var characterReplacement = function(s, k) {
    let freq = new Array(26).fill(0);
    let left = 0;
    let maxFreq = 0;  // stale — intentionally never decremented
    let maxLen = 0;

    for (let right = 0; right < s.length; right++) {

        // expand window
        freq[s.charCodeAt(right) - 65]++;
        maxFreq = Math.max(maxFreq, freq[s.charCodeAt(right) - 65]);

        let changes = (right - left + 1) - maxFreq;

        // window invalid → shrink by 1
        if (changes > k) {
            freq[s.charCodeAt(left) - 65]--;
            left++;
        }

        // window is monotonically non-decreasing
        maxLen = Math.max(right - left + 1, maxLen);
    }

    return maxLen;
};

/*
///// Optimal Approcah---1. ///////
var characterReplacement_optimal1 = function(s, k) {
    let maxlen = 0,
        left = 0,
        right = 0,
        freq = 0;
    const map = new Map();

    while(right < s.length) {
        map.has(s[right]) ? map.set(s[right], map.get(s[right])+1) : map.set(s[right],1);

        freq = Math.max(freq, map.get(s[right]));
        let changes = (right-left+1) - freq; 
        if(changes > k) {
            map.set(s[left], map.get(s[left])-1);
            if(map.get(s[left]) === 0) map.delete(s[left]);
            left++;
        }
        maxlen = Math.max(maxlen, right-left+1);
        right++;
    }
    return maxlen;

};
*/

/*
 ///////Brutre force soluiton///////
var characterReplacement_bruteForce = function(s, k) {
    maxlen = 0;
    for(let i=0;i<s.length;i++) {
        let hash = new Array(26).fill(0);
        let freq = 0;
        for(let j=i;j<s.length;j++) {
            hash[s.charCodeAt(j) - "A".charCodeAt(0)]++;
            freq = Math.max(freq, hash[s.charCodeAt(j) - "A".charCodeAt(0)]);

            let changes = (j-i+1) - freq;
            if(changes <= k) {
                maxlen = Math.max(maxlen, j-i+1);
            }
        }
    }
    return maxlen;
};
*/
