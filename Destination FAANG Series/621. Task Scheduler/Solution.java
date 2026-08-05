class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Step 1 : Count the frequency of each task 
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int interval = 0;
        for(int i=0; i < tasks.length; i++){
            freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i], 0)+1);
        } 

        //Step 2 : Sort the frequencies in descending order, the task with highest frequency get added first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        Iterator<Map.Entry<Character, Integer>> mapIter = freqMap.entrySet().iterator();
        while(mapIter.hasNext()){
            maxHeap.add(mapIter.next().getValue());
        }

        //Step 3 : Arrange and Count the tasks
        while(!maxHeap.isEmpty()) {
            
           //System.out.println("interval count: " + interval);
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.poll());
                }
                
            }
            for(int freq: temp){
                if(--freq > 0) {
                    maxHeap.offer(freq);
                }
            }

            //Step 4: Count intervals
            interval += maxHeap.isEmpty() ? temp.size(): n + 1;
        }
      return interval;  
    }
}