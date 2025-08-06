/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let lastChange = false; 
    let i = 1;
    const l = digits.length;
    while(lastChange === false) {
        if(digits[l-i] !== 9){
            digits[l-i] = digits[l-i] + 1;
            lastChange = true;
        }
        else {
            if(i !== l ){
                digits[l-i] = 0;
            }
            else {
                digits[0] = 0;
                digits.push(1);
                digits = digits.reverse();
                lastChange = true; 
            }
        }
        i++;
    }

    return digits;
    

};