class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        N = len(nums)
        res = []
        
        def dfs(curr, start):
            # Append a snapshot of the current subset
            res.append(list(curr))
            
            # Loop naturally terminates when start >= N
            for j in range(start, N):
                curr.append(nums[j])
                dfs(curr, j + 1)
                curr.pop()
        
        dfs([], 0)
        return res