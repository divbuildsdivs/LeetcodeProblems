class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        def backtrack(index, curr, total):
            if total > target:
                return
            elif total == target:
                res.append(list(curr))
                return
            for i in range(index, len(candidates)):
                if i > index and candidates[i] == candidates[i-1]:
                    continue
                if candidates[i] + total > target:
                    break
                else:
                    total += candidates[i]
                    curr.append(candidates[i])
                    backtrack(i+1, curr, total)
                    total -= candidates[i]
                    curr.pop()
        backtrack(0, [], 0)
        return res