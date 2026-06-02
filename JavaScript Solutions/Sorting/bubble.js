var bubbleSort = function(arr) {
    var i, j, temp;
    var a = [...arr];
    for(i = 0; i<arr.length-1; i++){
        for(j=0; j<arr.length-i-1; j++){
            if(a[j] > a[j+1]){
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
    }

    return a;
};

console.log(bubbleSort([5,1,4,2]));