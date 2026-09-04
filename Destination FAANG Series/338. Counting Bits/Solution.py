class Solution:
    def countBits(self, n: int) -> List[int]:
        dp = [0] * (n + 1)
        dp[0] = 0
        offset = 1
        for i in range(1, n+1):
            if i == (2 * offset):
                offset = (2 * offset)
            dp[i] = 1 + dp[i - offset]
            print(i, offset)
        return dp