function twoNumberSum(array, targetSum) {
  // Write your code here.
  const result = [];
  array.forEach((item) => {
    if (result.length > 0) return; // Stop if result is found
    let remainingArray = array.filter((x) => x !== item);
    remainingArray.forEach((x) => {
          if(x + item === targetSum) {
            result.push(item, x);
            return;
          }
      });
  })
  return result;
}

const inputObj = {
  "array": [3, 5, -4, 8, 11, 1, -1, 6],
  "targetSum": 10
}

console.log(twoNumberSum(inputObj.array, inputObj.targetSum)); // [11, -1] or [-1, 11] or [1, 9] or [9, 1]
// D