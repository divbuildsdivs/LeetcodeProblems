class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        s = ["", "","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        res = []
        def dfs(curr, index):
            if index == len(digits):
                res.append(str(curr))
                return
            digit = int(digits[index])
            for j in range(len(s[digit])):
                curr += s[digit][j]
                dfs(curr, index + 1)
                curr = curr[:-1]
        dfs("", 0)        
        return res