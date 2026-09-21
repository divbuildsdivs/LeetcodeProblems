class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m = len(num1)
        n = len(num2)
        resArray = [0 for i in range(m+n)]  
        if num1 == "0" or num2 == "0":
            return "0"
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                posUnit = i+j+1
                posTens = i + j

                mul = int(num1[i]) * int(num2[j])
                mul = mul + resArray[posUnit]

                resArray[posUnit] = mul % 10
                resArray[posTens] = resArray[posTens] + mul // 10
        return "".join(map(str,resArray)).lstrip("0")