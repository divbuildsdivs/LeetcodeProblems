class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        def backtrack(index, curr):
            if index >= len(s):
                res.append(list(curr))
                return
            for i in range(1, len(s) - index + 1):
                if checkPallindrome(s[index: index + i]):
                    curr.append(s[index: index + i])
                    backtrack(index + i, curr)
                    curr.pop()
        def checkPallindrome(str):
            l = len(str)
            for i in range(math.ceil(len(str)/2)):
                if str[i] != str[l-i-1]:
                    return False
            return True
        
        backtrack(0, [])
        return res

            

             