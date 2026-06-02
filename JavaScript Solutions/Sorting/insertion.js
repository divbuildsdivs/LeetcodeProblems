var insertionSort = function(arr) {
    var i, j;
    var a = [];
    a[0] = arr[0]
    for(i = 1; i<arr.length; i++){
        var ipos = 0;
        for(j=0; j<a.length; j++){
            if(arr[i] > a[j]){
                ipos = ipos + 1;
            }
        }
        a.splice(ipos, 0, arr[i]);
    }

    return a;
};

console.log(insertionSort([5,1,4,2]));

console.log(insertionSort([9,7, 5,2,2,61, 43,1,4,2]));