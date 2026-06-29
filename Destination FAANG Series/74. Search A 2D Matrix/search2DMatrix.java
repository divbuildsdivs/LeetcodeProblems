class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number 0f columns
        int l = m*n; //total number of elements
        int left = 0;
        int right = l - 1; //last index if 1 D array
        while(left <= right) {
            int mid = left + (right - left)/2;
            int midrow = mid/n;
            int midcol = mid % n;
            if(matrix[midrow][midcol] == target) {
                return true;
            }
            else if (matrix[midrow][midcol] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
        
    }
}