class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int ans = nums[0];
        int mid;
        if(nums.length == 1 ){
            return nums[0];
        }
        while(left <= right) {
            if(nums[left] <= nums[right]) {
                ans = Math.min(ans, nums[left]);
            }
            mid = left + (right - left)/2;
            if(nums[mid] >= nums[left] ) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
       }
       return ans;
    }
}