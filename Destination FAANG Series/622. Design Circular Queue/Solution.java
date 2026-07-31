class MyCircularQueue {
    int[] queue;
    int front = 0;
    int rear;
    int size = 0;
    int cap = 0;

    public MyCircularQueue(int k) {
        cap = k;
        queue = new int[cap];
        rear = cap - 1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        else {
            
            if(rear == (cap-1)) {
                rear=0;

            }
            else {
                rear++;
            }
            queue[rear] = value;
            
            size++;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        else {
            if(front == (cap-1)) {
                front =0;
            }
            else{
                front++;
            }
            size--;
        }
        return true;
        
    }
    
    public int Front() {
        
        if(isEmpty())
            return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return(size == 0);
    }
    
    public boolean isFull() {
        return size == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */