/**
 * @param {string} s
 * @return {boolean}
 */
var repeatedSubstringPattern = function(s) {
    var l = s.length;
    for( i = Math.floor(l/2); i >= 1 ; i--){
        var substr = s.substring(0, i);
        var concatStr = substr.repeat(l/i);
        if (concatStr === s) 
            return true;
    }
    return false;
};