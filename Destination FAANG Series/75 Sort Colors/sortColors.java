class Solution {
    public void sortColors(int[] nums) {
        // Logic:
        // 1. low marks the position where the next 0 should go.
        // 2. high marks the position where the next 2 should go.
        // 3. curr scans the array from left to right.
        // 4. If nums[curr] is 0, swap it to the front and move both low and curr.
        // 5. If nums[curr] is 2, swap it to the end and move high only.
        // 6. If nums[curr] is 1, it is already in the correct middle region, so move curr.
        int low = 0; 
        int high = nums.length - 1;
        int curr = 0;
        while(curr <= high){
            if(nums[curr] == 0){
                swap(low,curr,nums);
                low++;
                curr++;
            }
            else if(nums[curr] == 2){
                swap(high,curr,nums);
                high--;
            }
            else {
                curr++;
            }

        }
    }
    void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}