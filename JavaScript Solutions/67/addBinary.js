/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
    var arrayA = a.split("").reverse();
    var arrayB = b.split("").reverse();
    var maxArray = arrayA.length > arrayB.length ? arrayA : arrayB;
    var minArray = arrayB.length < arrayA.length ? arrayB : arrayA;
    var resultArray =[];
    var resultString = "";
    var carry = 0;

   for(let i =0 ; i<= maxArray.length; i++) {
    if(!Number(minArray[i]) && !Number(maxArray[i])){
        resultArray[i] = carry;
        carry =0;
    }
    if(Number(minArray[i]) && Number(maxArray[i])) {
        resultArray[i] = carry;
        carry =1;
    }
    if((!Number(minArray[i]) && Number(maxArray[i])) ||
     (Number(minArray[i]) && !Number(maxArray[i]))) {
        if(carry) {
          resultArray[i] = 0;
          carry = 1;  
        }
        else {
            resultArray[i] = 1;
            carry =0;
        }
    }
   }
   var joinedString = resultArray.reverse().join("");
   resultString = joinedString.indexOf('1') >= 0 ? joinedString.substring(joinedString.indexOf('1')) : '0';
   return resultString;
};