/**
 * @param {string} s
 * @return {number}
 */

///////optimal soltion//////
var numberOfSubstrings = function (s) {};

/*
 /////Brute force soluiton ////////////
var numberOfSubstrings_bruteForce = function(s) {
    let count = 0;
    for(let i=0;i<s.length;i++) {
        const set = new Set();
        for(let j=i;j<s.length;j++) {
            set.add(s[j]);
            if(set.size === 3) count++;
        }
    } 
    return count;
    
};
*/
