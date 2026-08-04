class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<> ((a,b) -> a-b);
        int i;
        for(i =0; i< k; i++){
            minHeap.offer(nums[i]);
        }
        for(i = k; i< nums.length; i++){
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
       
       return minHeap.poll();
    }
}