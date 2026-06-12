class Solution {
    public void nextPermutation(int[] nums) {
        // Scan from right to left to find the first "pivot" where the order breaks,
        // i.e. an element smaller than the one to its right. This is the spot we can
        // increase to get the next larger permutation.
        for(int i = nums.length - 2; i>=0; i--){
            if(nums[i] < nums[i+1]) {
                // Everything to the right of i is in descending order.
                // Find the smallest element there that is still greater than nums[i]
                // by scanning from the right (first one found qualifies).
                for(int j =  nums.length - 1; j> i; j--){
                    if(nums[j] > nums[i]){
                        // Swap the pivot with that next-greater element.
                        swap(nums, i, j);
                        // The suffix after i is still descending; reverse it to make it
                        // ascending (smallest possible), giving the immediate next permutation.
                        reverse(nums, i+1);
                        break;
                    }
                }
                // Pivot handled, so we're done.
               break; 
            }
            // If we reached the start without finding a pivot, the array is the
            // highest permutation (fully descending), so reverse it all to get
            // the lowest permutation (ascending) and wrap around.
            if(i == 0 && nums[i] >= nums[i+1]) {
                reverse(nums, i);
            }
        }
    }

    // Swaps the elements at indices i and j in place.
    public void swap (int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 

    // Reverses the portion of the array from index `pos` to the end in place.
    public void reverse (int[] nums, int pos) {
        int l = pos;
        int r = nums.length -1;
        while(l<r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}