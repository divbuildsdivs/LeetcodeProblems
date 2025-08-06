// 2637. Promise Time Limit
// Given an asynchronous function fn and a time t in milliseconds,
//  return a new time limited version of the input function.
//  fn takes arguments provided to the time limited function.

// The time limited function should follow these rules:

// If the fn completes within the time limit of t milliseconds,
//  the time limited function should resolve with the result.
// If the execution of the fn exceeds the time limit, 
// the time limited function should reject with the string "Time Limit Exceeded".

var timeLimit = function(fn, t) {
    
    return async function(...args) {
        var promise1 = new Promise((resolve) => resolve(fn(...args)));
        var promise2 =  new Promise((resolve, reject) => {
                setTimeout(() => reject("Time Limit Exceeded"), t)
            });
        return Promise.race([promise1, promise2]);
       
    }
    
};

var limitedFn = async function(n) {
    await new Promise(res => setTimeout(res, 100)); 
  return n * n; 
}

console.log(timeLimit(limitedFn, 50)(10).then(console.log).catch(console.error)); // "Time Limit Exceeded"
console.log(timeLimit(limitedFn, 200)(10).then(console.log).catch(console.error)); // 100