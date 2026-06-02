/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    const trimmedS = s.trim();
    let lastSpaceIndex = trimmedS.lastIndexOf(" ");
    return trimmedS.substring(lastSpaceIndex + 1, trimmedS.length).length;
    
};