class Solution:
    def jump(self, nums: List[int]) -> int:
        N = len(nums)
        final = N-1
        maxCoverage = 0
        jumpsCount = 0
        lastJumpIndex = 0
        if N == 1: return 0
        for i in range(N):
            if (i + nums[i]) > maxCoverage:
                maxCoverage = i + nums[i]
            if i == lastJumpIndex:
                lastJumpIndex = maxCoverage
                jumpsCount += 1
                
                if maxCoverage >= final:
                    return jumpsCount
        