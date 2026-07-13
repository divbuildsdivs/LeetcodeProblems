class Solution {
    public int trap(int[] height) {
        int l = 0; int r = height.length - 1;
        int leftMax = height[l]; int rightMax = height[r];
        int total = 0;

        // Move the side with the smaller boundary inward, because that side
        // determines the maximum water we can trap at the current step.
        while (l < r) {
            if(leftMax <= rightMax) {
                l = l+1;
                // Update the best left boundary seen so far.
                leftMax = Math.max(height[l], leftMax);
                // Water trapped at this index is bounded by leftMax.
                total = total + (leftMax - height[l]);
            }
            else {
                r = r - 1;
                // Update the best right boundary seen so far.
                rightMax = Math.max(height[r], rightMax);
                // Water trapped at this index is bounded by rightMax.
                total = total + (rightMax - height[r]);
            }
            
        } 
        return total;
    }
}