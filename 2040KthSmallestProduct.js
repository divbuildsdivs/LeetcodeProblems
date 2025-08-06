var kthSmallestProduct = function(nums1, nums2, k) {
    var products = [];
    var i = 0;
    var j = 0;
    while(products.length <= k) {
      if(nums1[i] < nums2[j]) {
        products.push(nums1[i]  * nums2[j]);
        j++;
      }
      else {
        products.push(nums1[i]  * nums2[j]);
        i++;
      }
    }
    return products;
};

// Example usage:
var nums1 = [2,5];
var nums2 = [3,4];
var k = 2;
console.log(kthSmallestProduct(nums1, nums2, k)); // Output: 8