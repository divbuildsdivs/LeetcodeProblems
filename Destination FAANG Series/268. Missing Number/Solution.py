class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        xorres = 0
        for i in range(len(nums)+1):
            xorres ^= i
        for i in range(len(nums)):
            xorres ^= nums[i]
        return xorres