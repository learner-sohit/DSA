// ===== Approach 1: Check All Internal Nodes Against Children =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean isMaxHeap(int[] arr) {
        int size = arr.length;

        // Only internal nodes (indices 0 to size/2 - 1) have children
        for (int i = 0; i < size / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // If any child is greater than the parent, it's not a max heap
            if (left < size && arr[i] < arr[left]) return false;
            if (right < size && arr[i] < arr[right]) return false;
        }
        return true;
    }
}
