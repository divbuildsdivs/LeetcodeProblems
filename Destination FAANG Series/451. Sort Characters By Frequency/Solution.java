class Solution {
    public String frequencySort(String s) {
       HashMap<Character, Integer> freqMap = new HashMap<>();
       for(int i =0; i< s.length(); i++) {
        if(freqMap.containsKey(s.charAt(i))) {
            freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
        }
        else {
            freqMap.put(s.charAt(i), 1);
        }
       } 
       PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
       Iterator<Map.Entry<Character, Integer>> mapIter = freqMap.entrySet().iterator();
       while(mapIter.hasNext()){
        Map.Entry<Character, Integer> entry = mapIter.next();
        maxHeap.offer(entry);
       }
       StringBuilder res = new StringBuilder();
       while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> el = maxHeap.poll();
            int freq = el.getValue();
            for(int x =0; x < freq; x++) {
                res.append(el.getKey());
            }      
        }
        return res.toString();
    }
}