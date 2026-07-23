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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<> ();
        for(int i=0; i < lists.length; i++) {
            while(lists[i] != null) {
                minHeap.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        ListNode head = null;
        if(!minHeap.isEmpty()) {
            head = new ListNode(minHeap.remove());
        
            ListNode dummy = head;

            while(!minHeap.isEmpty()) {
                ListNode el = new ListNode(minHeap.remove());
                dummy.next = el;
                dummy = dummy.next;
            }
        }
        return head;
    }
}