class Solution:
    def numDecodings(self, s: str) -> int:
        N = len(s)
        waysArr = [0] * (N + 1)
        waysArr[0] = 1 #if there are 0 digits there will be only one way to decode i.e empty string
        waysArr[1] = 1 if s[0] != "0" else 0   #if first digit is 0, the string cannot be decoded as it is invalid so 0 ways

        for i in range(2, N+1):
            oneDigit = int(s[i-1]) 
            twoDigits = int(s[i-2: i])
        
            if(oneDigit != 0 ):
                waysArr[i] += waysArr[i-1]
            
            if 10 <= twoDigits <= 26:
                waysArr[i] += waysArr[i-2]
        return waysArr[N]