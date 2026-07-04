// ===== Approach 1: Greedy — Track $5 and $10 Bills =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                // bills[i] == 20: need to give $15 change
                if (five >= 1 && ten >= 1) {
                    // Prefer giving $10 + $5 (saves $5 bills for future)
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
