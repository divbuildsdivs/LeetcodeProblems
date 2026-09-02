class Solution:
    def hammingWeight(self, n: int) -> int:
        mul = 1
        count = 0
        for i in range(32):
            if(n > mul):
                mul *= 2
            else:
                break
        while n > 0:
            if n >= mul:
                count += 1
                n = n - mul
            mul = mul//2
        return count
