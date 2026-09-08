class Solution:
    def checkValidString(self, s: str) -> bool:
        openMax, openMin = 0, 0

        for ch in s:
            if ch == "(":
                openMax += 1
                openMin += 1
            elif ch == ")":
                openMax -= 1
                openMin -= 1
            elif ch == "*":
                openMax += 1
                openMin -= 1

            if openMax < 0:
                return False

            openMin = max(0, openMin)

        return openMin == 0