/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    var dividend = x;
    var reverseNum = 0;
    while(dividend > 0) {
        reverseNum = reverseNum * 10 + Math.floor((dividend % 10));
        dividend = Math.floor(dividend/10);
    }

    if(x === reverseNum){
        return true;
    }
    return false;
};

console.log(isPalindrome(121)); // true
console.log(isPalindrome(-121)); // false    