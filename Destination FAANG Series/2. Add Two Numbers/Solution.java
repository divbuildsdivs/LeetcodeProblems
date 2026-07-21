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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode res = new ListNode();
        ListNode dummy = res;
        while(l1 != null || l2 != null){
            ListNode dig = new ListNode();
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null )? 0 : l2.val;
            int val = val1 + val2 + carry;
            
            carry = val/10;
            dig.val = val%10;
            res.next = dig;
            res = res.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry != 0){
            ListNode dig = new ListNode();
            dig.val = carry;
            res.next = dig;
        }
        return dummy.next;
    }
}