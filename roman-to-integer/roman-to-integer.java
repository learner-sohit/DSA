import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/roman-to-integer/
 */
class Solution {

    // Compare each symbol with its next symbol to handle subtractive notation.
    // Time Complexity: O(N); Space Complexity: O(1).
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));
            int next = i + 1 < s.length() ? map.get(s.charAt(i + 1)) : 0;

            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
