class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
       
        List<List<Integer>> result = new ArrayList<>();
        int right,left, twoSumTarget;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            int secondEl = nums[0] - 1;
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            twoSumTarget = 0 - nums[i];
            right = i + 1;
            left = nums.length -1;
            while(right < left && right < nums.length && left > i ){
                List<Integer> triplet = new ArrayList<> ();
                
                if(nums[left] + nums[right] == twoSumTarget && nums[right] != secondEl && nums[left] != secondEl){
                    triplet.add(nums[i]);
                    triplet.add(nums[right]);
                    triplet.add(nums[left]);
                    result.add(triplet);
                    secondEl = nums[right];
                    right++;
                }
                else if(nums[left] + nums[right] < twoSumTarget) {
                    right++;
                }
                else {
                    left--;
                }
            }
        }
        return result;
    }
}