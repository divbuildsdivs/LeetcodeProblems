var selectionSort = function(arr) {
    var i, j, min, minpos;
    //var a = [arr.length];
    for(i = 0; i<arr.length; i++){
        min = arr[i];
        minpos = i;
        for(j=i+1; j<arr.length; j++){
            if(arr[j] < min){
                min = arr[j];
                minpos = j;
            }
        }
        arr[minpos] = arr[i]
        arr[i] = min;
    }

    return arr;
};

console.log(selectionSort([5,1,4,2]));
console.log(selectionSort([9,7, 5,2,2,61, 43,1,4,2]));