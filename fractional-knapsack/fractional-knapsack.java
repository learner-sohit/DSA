// ===== Approach 1: Greedy — Sort by Value/Weight Ratio =====
// Time Complexity: O(n log n) | Space Complexity: O(n)
class Solution {
    class Item {
        int val;
        int wt;

        Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        Item[] items = new Item[val.length];

        for (int i = 0; i < val.length; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // Sort by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> {
            return Double.compare((double) b.val / b.wt, (double) a.val / a.wt);
        });

        double maxValue = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i].wt <= capacity) {
                maxValue += items[i].val;
                capacity -= items[i].wt;
            } else {
                maxValue += ((double) items[i].val / (double) items[i].wt) * capacity;
                break;
            }
        }
        return maxValue;
    }
}
