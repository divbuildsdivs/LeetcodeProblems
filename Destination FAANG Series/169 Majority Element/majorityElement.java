class Solution {
    public int majorityElement(int[] nums) {
        int res  = 0;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer> ();
        for(int i =0; i<nums.length; i++){
            addToHashMap(nums[i], hmap);
        }

        for(Map.Entry<Integer, Integer> entry: hmap.entrySet() ){
            if(entry.getValue() > Math.floor(nums.length/2)) {
                res = entry.getKey();
                break;
            }
        }
    return res;
        
    }
    void addToHashMap(int x, HashMap<Integer, Integer> hmap){
        if(hmap.containsKey(x)){
            hmap.put(x, hmap.get(x) + 1);
        }
        else 
            hmap.put(x, 1);
    }
}