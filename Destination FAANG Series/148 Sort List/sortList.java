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
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: a list with 0 or 1 node is already sorted.
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves, sort each half, then merge them.
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }

    ListNode getMid(ListNode head) {
        // Use slow/fast pointers to find the node before the midpoint.
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut the list into two pieces: head ... slow and mid ... end.
        ListNode mid = slow.next;
        slow.next = null;
        
        return mid;
    }

    ListNode merge(ListNode left, ListNode right) {
        // Dummy node simplifies building the merged list.
        ListNode sorted = new ListNode(0);
        ListNode startcopy = sorted;
        while (left != null && right != null) {
            if (left.val < right.val) {
                sorted.next = left;
                left = left.next;
            }
            else {
                sorted.next = right;
                right = right.next;
            }
            sorted = sorted.next;
        }

        // Attach whichever list still has nodes left.
        if (left != null) {
            sorted.next = left;
        }
        else if (right != null) {
            sorted.next = right;
        }

        return startcopy.next;

    }
}