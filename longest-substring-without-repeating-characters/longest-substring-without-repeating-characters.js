/**
 * @param {string} s
 * @return {number}
 */

//// Brute-force solution ///////
var lengthOfLongestSubstring_bruteForce = function (s) {
  let maxLen = 0;

  for (let i = 0; i < s.length; i++) {
    let hash = [];
    for (let j = i; j < s.length; j++) {
      if (hash[s[j]] == 1) break;
      maxLen = Math.max(maxLen, j - i + 1);
      hash[s[j]] = 1;
    }
  }
  return maxLen;
};

//// Optimal solution ///////
var lengthOfLongestSubstring = function (s) {
  let maxLen = 0,
    len = 0,
    left = 0,
    right = 0;
  const map = new Map();

  while (right < s.length) {
    if (map.has(s[right])) {
      let idx = map.get(s[right]);
      if (idx >= left) left = map.get(s[right]) + 1;
    }

    map.set(s[right], right);
    len = right - left + 1;
    maxLen = Math.max(len, maxLen);
    right++;
  }
  return maxLen;
};
