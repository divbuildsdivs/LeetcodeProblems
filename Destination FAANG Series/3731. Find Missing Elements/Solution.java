class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> missingDigits = new ArrayList<>();
        int i = nums[0];
        int j = 0;
       while(i< nums[nums.length - 1]) {
        if(i == nums[j]) {
            j++;
        }
        else{
            missingDigits.add(i);
        }
        i++;
       }
       return missingDigits;
    }
}