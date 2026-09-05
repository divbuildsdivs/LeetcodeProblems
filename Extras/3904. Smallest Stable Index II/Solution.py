class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        n = len(nums)

        dpmax = [nums[0]] * n
        dpmin = [nums[n - 1]] * n

        for i in range(1, n):
            dpmax[i] = max(dpmax[i - 1], nums[i])
            dpmin[n - 1 - i] = min(dpmin[n - i], nums[n - 1 - i])


        for i in range(0, n):
            if dpmax[i] - dpmin[i] <= k:
                return i
        return -1