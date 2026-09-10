class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        def dfs(curr, start):
            res.append(list(curr))
            for i in range(start, len(nums)):
                if i > start and (nums[i] == nums[i-1]):
                    continue
                curr.append(nums[i])
                dfs(curr, i + 1)
                curr.pop()
        dfs([], 0)
        return res
