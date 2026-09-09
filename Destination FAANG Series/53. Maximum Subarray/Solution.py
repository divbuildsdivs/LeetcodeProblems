class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSoFar= nums[0]
        currMax = nums[0]
        for i in range(1, len(nums)):
            currMax = max(nums[i], currMax + nums[i])
            maxSoFar = max(currMax, maxSoFar) 
        return maxSoFar