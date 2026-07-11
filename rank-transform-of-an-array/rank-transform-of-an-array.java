// ===== Approach 2: Optimal — Sort + HashMap for rank lookup =====
// Time Complexity: O(n log n) | Space Complexity: O(n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        for (int i = 0; i < n; i++) {
            sorted[i] = map.get(arr[i]);
        }
        return sorted;
    }
}

/*
// ===== Approach 1: Brute Force — For each element, scan sorted array =====
// Time Complexity: O(n^2) | Space Complexity: O(n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] sorted = arr.clone();

        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (j > 0 && sorted[j] != sorted[j - 1]) rank += 1;
                if (sorted[j] == arr[i]) {
                    ans[i] = rank;
                    break;
                }
            }
        }
        return ans;
    }
}
*/
