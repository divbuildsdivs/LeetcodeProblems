class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Logic:
        // 1. Treat m - 1 and n - 1 as the last valid elements in nums1 and nums2.
        // 2. Use i at the end of nums1 as the write position.
        // 3. Compare the current largest values from both arrays and place the larger one at i.
        // 4. Move backward until all elements from nums2 are merged into nums1.
        int i = nums1.length - 1;
        m = m-1;
        n = n-1;
        while(n>=0){
            if(m == -1 || nums2[n] > nums1[m] ) {
                nums1[i] = nums2[n];
                n--;
            }
            else {
                nums1[i] = nums1[m];
                m--;
            }
            i--;
        }

    }
}