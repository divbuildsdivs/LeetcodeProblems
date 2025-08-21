var singleNumber = function(nums) {
    nums.sort();
    for (let i = 0; i < nums.length; i += 2) {
        if (i === nums.length - 1 || nums[i] !== nums[i + 1]) {
            return nums[i];
        }
    }
};

// Test cases
console.log(singleNumber([2, 2, 1])); // Output: 1  
// console.log(singleNumber([4, 1, 2, 1, 2])); // Output: 4
// console.log(singleNumber([1])); // Output: 1