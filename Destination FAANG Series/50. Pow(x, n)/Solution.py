class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x,n):
            if x == 0: return 0
            if n == 0: return 1
            pow = helper(x, n//2)
            pow = pow * pow
            return pow if n%2 == 0 else x*pow
        res = helper(x,abs(n))
        return res if n >= 0 else 1/res