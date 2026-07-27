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
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 1;
        ListNode newHead = head;
        ListNode merge = new ListNode();
        ListNode tail = merge;
        Boolean kNodesExists = true;
        while(head != null){
            newHead = head;
            for(int j = 0; j<k; j++){
                if(head == null){
                    kNodesExists = false;
                    break;
                }
                head = head.next;
            }
            if(kNodesExists){
                tail.next = reverseChunks(newHead, k);     
                tail = newHead;
            }
            if(!kNodesExists){
                tail.next = newHead;
                break;
            }      
        }

        return merge.next;
         
    }

    ListNode reverseChunks(ListNode head, int k) {
        ListNode dummy = null;
        ListNode tail = head;
        
        for(int i = 0; i<k; i++ ) {
            ListNode temp = head;
            head = head.next;
            temp.next = dummy;
            dummy = temp;
        }
        tail.next = null;
        return dummy;
    }
}