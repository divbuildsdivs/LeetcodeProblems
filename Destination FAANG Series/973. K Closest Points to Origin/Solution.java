class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<> ((a,b) -> (b[0] *b[0] + b[1] * b[1]) -(a[0] * a[0] + a[1] * a[1]));
        int i;
        for(i =0; i< k; i++){
            maxHeap.offer(points[i]);
        }
        for(i = k; i< points.length; i++){
            int distancei =points[i][0] *points[i][0] + points[i][1] * points[i][1];
            int distanceMax = maxHeap.peek()[0] *maxHeap.peek()[0] + maxHeap.peek()[1] * maxHeap.peek()[1];
            if(distancei < distanceMax) {
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        }
       int[][] results = new int[k][2];
       for(int j =0; j< k; j++) {
        results[j] = maxHeap.poll();
       }
       return results;
    }
}