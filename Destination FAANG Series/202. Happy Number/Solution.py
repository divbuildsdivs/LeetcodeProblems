class Solution:
    def isHappy(self, n: int) -> bool:
        visited = set()
        while n > 0 and n not in visited:
            print(n)
            visited.add(n)
            nstr = str(n)
            n = 0
            for i in range (len(nstr)):
                n += int(nstr[i]) * int(nstr[i])

        return n == 1 