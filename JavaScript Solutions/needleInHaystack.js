/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    let nl = needle.length;
    let hl = haystack.length
    let i;
    if(nl > hl)
        return -1;
    else {
        for(i =0 ; i<= (hl - nl); i++){
            if(haystack.substring(i, i + nl) === needle){
                return i;
            }
        }

        return -1;
        
    }
    
};