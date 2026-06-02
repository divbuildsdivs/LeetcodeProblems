/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    var str = s.toLowerCase().replace(/[^a-z0-9]/g, '');
    var l = str.length;
    for(let i =0; i<Math.floor(l/2);i++){
        if(str.charAt(i) !== str.charAt(l-1-i))
            return false;
    }
    return true;
};

