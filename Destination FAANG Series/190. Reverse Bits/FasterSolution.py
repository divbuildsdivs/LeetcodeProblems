class Solution:
    def reverseBits(self, n: int) -> int:
        div = pow(2, 31)
        result = 0
        for i in range(32):
            bit = n & 1
            n = n >> 1
            result += div * bit
            div = div//2
        return result