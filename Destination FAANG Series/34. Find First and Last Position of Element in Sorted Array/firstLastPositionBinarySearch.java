class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findStart(nums,target);
        if(start == -1) {
            return new int[]{-1, -1};
        }
        int end = findEnd(nums,target,start);
        return new int[] {start, end};
    }

    int findStart(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        int mid;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid]==target && (mid == 0 || nums[mid - 1]!= target)){
                return mid;
            }
            else if(nums[mid]>=target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        } 
        return -1;
    }
    int findEnd(int[] nums, int target, int start) {
        int left = start + 1;
        int right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target && (mid == nums.length -1 || nums[mid + 1]!= target )){
                return mid;
            } 
            else if(nums[mid] == target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        } 
        return start;
    }
}