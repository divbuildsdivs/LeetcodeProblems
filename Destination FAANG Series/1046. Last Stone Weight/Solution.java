class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size() > 1) {
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();
            if(max1 != max2) {
                maxHeap.offer(max1 - max2);
            }
        }
        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
        
    }
}