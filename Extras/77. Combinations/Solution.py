class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        def dfs(curr, currentNumber):
            if len(curr) == k:
                res.append(list(curr))
                return
            for j in range(currentNumber, n+1):
                curr.append(j)
                dfs(curr, j + 1)
                curr.pop()

        dfs([], 1)
        return res
        