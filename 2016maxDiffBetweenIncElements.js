// Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] 
// (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

// Return the maximum difference. If no such i and j exists, return -1.



 /**
 * @param {number[]} nums
 * @return {number}
 */
var maximumDifferenceMySol = function(nums) {
    var diffArray = [];
    for(let i =0; i<nums.length; i++) {
        for(let j = i+1; j<nums.length; j++){
            if(nums[i] < nums[j]){
                diffArray.push([nums[j] - nums[i]]);
            }
        }
    }
   if(diffArray.length > 0) {
    return Math.max(...diffArray);
   }
   return -1;
};

//EfficientCode:
var maximumDifference = function(nums) {
    let minSoFar = nums[0];
    let maxDiff = -1;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > minSoFar) {
            maxDiff = Math.max(maxDiff, nums[i] - minSoFar);
        } else {
            minSoFar = nums[i];
        }
    }

    return maxDiff;
};


console.log(maximumDifference([7,1,5,4])); // 4
console.log(maximumDifference([9,4,3,2])); // -1 
console.log(maximumDifference([1,5,2,10])); // 9