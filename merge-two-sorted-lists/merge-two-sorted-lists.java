/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// ===== Approach 1: Optimal — Iterative Two Pointer with Dummy Node =====
// Time Complexity: O(n + m) | Space Complexity: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // Attach remaining nodes
        if (list1 == null) {
            while (list2 != null) {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }
        if (list2 == null) {
            while (list1 != null) {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
