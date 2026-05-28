/**
 * @param {string} s
 * @return {number}
 */

///////optimal soltion//////
var numberOfSubstrings = function (s) {
  const lastSeen = [-1, -1, -1]; // [a, b, c]
  let count = 0;

  for (let i = 0; i < s.length; i++) {
    lastSeen[s.charCodeAt(i) - "a".charCodeAt(0)] = i;

    if (lastSeen[0] !== -1 && lastSeen[1] !== -1 && lastSeen[2] !== -1) {
      count += 1 + Math.min(...lastSeen);
    }
  }

  return count;
};

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
