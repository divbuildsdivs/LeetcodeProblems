class Solution:
    def checkDivisibility(self, n: int) -> bool:
        str_n = str(n)
        a = 0
        b = 1 
        for i in range(len(str_n)):
            dig = int(str_n[i])
            a += dig
        return math.fmod(n,(a+b)) == 0