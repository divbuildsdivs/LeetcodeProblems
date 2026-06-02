var longestCommonPrefix = function(strs) {
    let commonPrefix = "";
    let checkPrefix ="";
    for(let i=0; i<strs[0].length; i++) {
        checkPrefix = commonPrefix + strs[0].charAt(i);
        for(let j =0; j<strs.length; j++) {
            if(!strs[j].startsWith(checkPrefix)) {
                return commonPrefix;
            }
        }
        commonPrefix = checkPrefix;
    }
    return commonPrefix;
};
//console.log(longestCommonPrefix(["flower","flow","flight"])); // "fl"
//console.log(longestCommonPrefix(["dog","racecar","car"])); // ""
console.log(longestCommonPrefix([""])); // ""