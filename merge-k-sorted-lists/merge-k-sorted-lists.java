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

// ===== Approach 3: Optimal — Min Heap (Priority Queue) =====
// Time Complexity: O(N log k) | Space Complexity: O(k) — k = number of lists, N = total nodes
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min Heap ordered by node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Seed the heap with the head of each non-null list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) pq.offer(lists[i]);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll(); // Extract the globally smallest node
            if (temp.next != null) pq.offer(temp.next); // Push its successor
            curr.next = temp;
            curr = curr.next;
        }
        return dummy.next;
    }
}

/*
// ===== Approach 2: Better — Sequential Merge (Merge one list at a time) =====
// Time Complexity: O(k * n) | Space Complexity: O(1) — k = number of lists, n = avg list length
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        for (int i = 0; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
*/

/*
// ===== Approach 1: Brute Force — Collect all values, sort, rebuild =====
// Time Complexity: O(N log N) | Space Complexity: O(N) — N = total number of nodes
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                list.add(curr.val);
                curr = curr.next;
            }
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int i = 0; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }
}
*/
