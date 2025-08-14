/**
 * @param {number} rowIndex
 * @return {number[][]}
 */
var getRow = function(rowIndex) {
    var arr = [[1]];
    for(let i = 1; i<=rowIndex; i++) {
        arr[i] = [];
        for(j = 0; j<=i; j++){
            if(j == 0 || j == i) {
                arr[i][j] = 1;
            }
            else {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
    }
    return arr[rowIndex]; // Return the specified row or [1] if rowIndex is 0
};

// Example usage:
console.log(getRow(5)); // Generates Pascal's Triangle row with index 5
// Note: The function getRow is designed to generate the entire Pascal's Triangle up to the specified rowIndex.

