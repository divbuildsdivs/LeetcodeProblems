/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    var arr = [[1]];
    for(let i = 1; i<numRows; i++) {
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
    return arr;
};

// Example usage:
console.log(generate(5)); // Generates Pascal's Triangle with 5 rows

