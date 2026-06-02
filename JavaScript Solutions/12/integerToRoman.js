/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    var roman = "";
    var digitsDictionary = [
    ["CM", "D", "CD", "C"],
     ["XC", "L", "XL", "X" ],
     ["IX", "V", "IV", "I"]
    ]
    var setDigitRoman = function(digit, arr) {
        var digitRoman = "";
         if(digit === 9){
                digitRoman  = digitRoman + arr[0];
            }
            else if(digit >= 5) {
                digitRoman = arr[1] + arr[3].repeat(digit - 5);

            }
            else if(digit === 4){
                digitRoman = arr[2]
            }
            else {
                digitRoman = arr[3].repeat(digit);
            }
            return digitRoman;

    }
    while(num > 0) {
        var digit;
        if(num >= 1000) {
            digit = Math.floor(num/1000);
            roman = roman + "M".repeat(digit); 
            num = num - digit * 1000;
        }
        else if (num >= 100) {
            
            digit = Math.floor(num/100);
            roman = roman + setDigitRoman(digit, digitsDictionary[0]);
            num = num%100;
        }
         else if (num >= 10) {
            digit = Math.floor(num/10);
            roman = roman + setDigitRoman(digit, digitsDictionary[1]);
            num = num%10;
        }
         else if (num < 10 ) {
            digit = num;
            roman = roman + setDigitRoman(digit, digitsDictionary[2]);
            num = 0;
        }
    }
    return roman;
};