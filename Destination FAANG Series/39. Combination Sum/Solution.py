class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def backtrack(index, curr):
            
            if len(curr) > 0 and sum(curr) > target:
                return
            elif len(curr) > 0 and sum(curr)== target:
                res.append(list(curr))
                return
            for i in range(index, len(candidates)):
                curr.append(candidates[i])
                backtrack(i, curr)
                curr.pop()
        backtrack(0, [])
        return res    s