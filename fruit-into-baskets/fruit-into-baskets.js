/**
 * @param {number[]} fruits
 * @return {number}
 */

///////OPTIMAL APPROCAH///////////
var totalFruit = function (fruits) {
  let maxlen = 0,
    left = 0,
    right = 0;
  const map = new Map();

  while (right < fruits.length) {
    map.has(fruits[right])
      ? map.set(fruits[right], map.get(fruits[right]) + 1)
      : map.set(fruits[right], 1);

    if (map.size > 2) {
      map.set(fruits[left], map.get(fruits[left]) - 1);
      if (map.get(fruits[left]) === 0) map.delete(fruits[left]);
      left++;
    }
    maxlen = Math.max(maxlen, right - left + 1);
    right++;
  }
  return maxlen;
};

/*

 ///////Brute force solution/////
var totalFruit_bruteForce = function(fruits) {
    const baskets = 2;
    let max = 0;

    for(let i=0;i<fruits.length;i++) {
        const set = new Set();
        for(let j=i;j<fruits.length;j++) {
            set.add(fruits[j]);
            if(set.size <= baskets) {
                max = Math.max(max, j-i+1);
            }else {
                break;
            }
        }
    }  
    return max;
};

*/
