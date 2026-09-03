#Destination Faang solution
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        wordSet = set(wordDict)
        maxLen = 0
        for word in wordDict:
            maxLen = max(maxLen, len(word))
        dp =[False] * (n+1)
        dp[0] = True
        for i in range(1, n+1):
            for j in range(max(0,i-maxLen), i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break
        
        return dp[n]