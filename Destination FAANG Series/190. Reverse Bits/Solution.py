class Solution:
    def reverseBits(self, n: int) -> int:
        bit = 0
        result = 0
        for i in range(32):
            bit = n & 1
            n = n >> 1
            result = result << 1
            result = result | bit
        return result