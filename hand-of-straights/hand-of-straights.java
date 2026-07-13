import java.util.*;

// ===== Approach 1: Greedy — Sort + HashMap Frequency Count =====
// Time Complexity: O(n log n) | Space Complexity: O(n)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {
            // Skip cards already fully used up
            if (map.get(num) == 0) continue;

            // Try to form a consecutive group starting at `num`
            for (int i = 0; i < groupSize; i++) {
                int card = num + i;
                if (map.getOrDefault(card, 0) == 0) return false;
                map.put(card, map.get(card) - 1);
            }
        }

        return true;
    }
}
