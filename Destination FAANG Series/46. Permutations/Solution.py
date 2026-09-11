class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(curr):
            if(len(curr) == len(nums) ):
                res.append(list(curr))
                return
            for i in range(len(nums)):
                if nums[i] in curr:
                    continue
                curr.append(nums[i])
                dfs(curr)
                curr.pop()
        dfs([])
        return res