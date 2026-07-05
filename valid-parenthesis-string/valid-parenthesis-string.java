// ===== Approach 2: Optimal — Greedy with Low/High Range =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean checkValidString(String s) {
        int low = 0;  // minimum possible open brackets
        int high = 0; // maximum possible open brackets

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else { // ch == '*'
                low--;  // treat '*' as ')'
                high++; // treat '*' as '('
            }

            if (low < 0) low = 0; // can't have negative open count
            if (high < 0) return false; // even the maximum possible open count went negative
        }
        return low == 0;
    }
}

/*
// ===== Approach 1: Brute Force — Recursion (Try all '*' options) =====
// Time Complexity: O(3^n) | Space Complexity: O(n) — recursion stack
class Solution {
    public boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }

    private boolean helper(String s, int idx, int count) {
        if (count < 0) return false;
        if (idx == s.length()) return count == 0;

        char ch = s.charAt(idx);
        if (ch == '(') return helper(s, idx + 1, count + 1);
        else if (ch == ')') return helper(s, idx + 1, count - 1);

        // ch == '*': try all three possibilities
        return helper(s, idx + 1, count + 1)  // '*' as '('
            || helper(s, idx + 1, count - 1)  // '*' as ')'
            || helper(s, idx + 1, count);      // '*' as ''
    }
}
*/
