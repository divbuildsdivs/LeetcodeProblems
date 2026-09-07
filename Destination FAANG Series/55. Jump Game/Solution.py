class Solution:
    def canJump(self, nums: List[int]) -> bool:
        N = len(nums)
        final = N-1
        for i in range(N-2, -1, -1):
            if nums[i] + i >= final:
                final = i
        return True if final == 0 else False