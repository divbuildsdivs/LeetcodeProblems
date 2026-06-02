var isValid = function(s) {
    var sArray = s.split("");
    
    for(let i=0; i<sArray.length; i++){
        if(sArray[i] === ']') {
            if(sArray[i-1] === '['){
                sArray.splice(i-1,2);
                i = i-2;
            }
            else {
                return false;
            }
        }
        if(sArray[i] === '}') {
            if(sArray[i-1] === '{'){
                sArray.splice(i-1,2);
                i = i-2;
            }
            else {
                return false;
            }
        }
        if(sArray[i] === ')') {
            if(sArray[i-1] === '('){
                sArray.splice(i-1,2);
                i = i-2;
            }
            else {
                return false;
            }
        }
    }
    if(sArray.length > 0) {
        return false;
    }
    return true;
};

console.log(isValid("()")); // true
console.log(isValid("()[]{}")); // true  
console.log(isValid("(]")); // false
console.log(isValid("([)]")); // false   