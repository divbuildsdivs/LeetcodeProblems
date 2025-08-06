/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let lastValue = nums[0];
    let k = nums.length;
    let count =0;
    for(let i =1; i< nums.length; i++){
        if(nums[i] === lastValue){
            nums[i] = 200;
            count++;
        }
        else {
            lastValue = nums[i];
        }
    }
    
    nums = nums.sort((a,b) => a - b);
    console.log(nums);
    return k-count;

};

console.log(removeDuplicates([1,1,2])); // Output: 2
console.log(removeDuplicates([0,0,1,1,1,2,2,3,3,4])); // Output: 5  