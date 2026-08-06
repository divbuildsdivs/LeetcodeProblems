class MedianFinder {
    PriorityQueue<Integer> lo; //maxHeap
    PriorityQueue<Integer> hi; //minHeap
    public MedianFinder() {
        lo = new PriorityQueue<>((a,b) -> b - a);
        hi = new PriorityQueue<>((a,b) -> a - b);
    }
    // lo can have 1 element more than hi
    //lo should have all the first half of the integers
    // hi should have all the second half of integers
    
    public void addNum(int num) {
        lo.offer(num);

        //moving the largest number in lo to hi (maxHeap to minHeap)
        hi.offer(lo.poll());
        if(lo.size() < hi.size()){
            lo.offer(hi.poll()); // if the hi has more integers, it sends the smallest one to the lo
        }
        //two heaps are created;  lo has all the first half of the sorted integers in descending order
        // hi has all the last ones in ascending order
    }
    
    public double findMedian() {
     return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */