/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = head;
        Map<Node, Node> oldToCopyMap = new HashMap<>();
        oldToCopyMap.put(null, null);
        while(dummy != null) {
            Node copyNode = new Node(dummy.val);
            oldToCopyMap.put(dummy, copyNode);
            dummy = dummy.next;
        }
        dummy = head;
        while (dummy != null){
            Node copyNode = oldToCopyMap.get(dummy);
            copyNode.next = oldToCopyMap.get(dummy.next);
            copyNode.random = oldToCopyMap.get(dummy.random);
            dummy = dummy.next;
        }
        return oldToCopyMap.get(head);
    }
}