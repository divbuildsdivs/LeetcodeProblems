class MinStack {
    private Node head;

    public MinStack() {
        
    }
    
    public void push(int value) {
        if(head == null) {
            head = new Node(value, value, null);
        }
        else {
            
            Node next = head;
            head = new Node(value, Math.min(head.min, value), next);
        }
        
    }
    
    public void pop() {
        head = head.next;
        
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    } 
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */