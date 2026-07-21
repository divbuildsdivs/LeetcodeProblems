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

/*
Logic:
1. Use a dummy node so attaching merged nodes is straightforward.
2. Compare the current nodes from both lists and link the smaller one.
3. Move the pointer of the list we used and advance the merged tail.
4. When one list ends, attach the remaining nodes from the other list.

Time: O(n + m)
Space: O(1)
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;

        // Build the merged list by always choosing the smaller current node.
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }
            else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        // Only one list can still have nodes left, so attach it directly.
        if(list1 != null){
            dummy.next = list1;
        }
        else if(list2 != null) {
            dummy.next = list2;
        }
        return result.next;
    }
}