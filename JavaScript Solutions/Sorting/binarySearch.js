var binarySearch = function(arr, key) {
    let found = false;
    let sortedArray = arr.sort((a,b) => a-b);
    while(sortedArray.length/2 >= 1) {
       
        if(key > sortedArray[Math.ceil(sortedArray.length/2) - 1]){
            console.log(sortedArray[Math.ceil(sortedArray.length/2) - 1])
            sortedArray.splice(0,Math.ceil(sortedArray.length/2));
        }
        else {
            console.log(sortedArray[Math.ceil(sortedArray.length/2) - 1])
            sortedArray.splice(Math.ceil(sortedArray.length/2), Math.floor(sortedArray.length/2));
        }
         console.log(sortedArray);
    }
    
    
    
    return sortedArray[0] === key;
};

console.log(binarySearch([5,1,4,2,3,9,6], 7));

console.log(binarySearch([9,7, 5,2,2,61, 43,1,4,2], 61));