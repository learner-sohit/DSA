import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// ===== Approach 1: Greedy — Sort by End Time =====
// Time Complexity: O(n log n) | Space Complexity: O(n)
class Solution {
    class MeetInfo {
        int start;
        int end;
        int idx;

        MeetInfo(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }

    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        MeetInfo[] meeting = new MeetInfo[s.length];

        for (int i = 0; i < s.length; i++) {
            meeting[i] = new MeetInfo(s[i], f[i], i + 1);
        }

        // Sort by end time; break ties by original index
        Arrays.sort(meeting, (a, b) -> {
            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.idx, b.idx);
        });

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meeting[0].idx);
        int endTime = meeting[0].end;

        for (int i = 1; i < meeting.length; i++) {
            if (meeting[i].start > endTime) {
                ans.add(meeting[i].idx);
                endTime = meeting[i].end;
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
