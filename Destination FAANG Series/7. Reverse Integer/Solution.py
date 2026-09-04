class Solution:
    def reverse(self, x: int) -> int:
        MIN = (2 ** 31) * -1
        MAX = (2 ** 31) - 1
        res = 0
        absx = abs(x)
        while absx:
            rem = int(math.fmod(absx,10))
            res = res*10 + rem
            absx = absx//10
        if(x < 0):
            res = res * -1
        return res if MIN <= res <= MAX else 0