class MyStack {
    Queue<Integer> q1; 

    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
       for(int i =0; i<q1.size() -1 ; i++){
        q1.offer(q1.poll());
       }
        return q1.poll();
    }
    
    public int top() {
        for(int i =0; i<q1.size() -1 ; i++){
            q1.offer(q1.poll());
        }
        int topValue = q1.poll();
        q1.offer(topValue);
        return topValue;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
   
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */