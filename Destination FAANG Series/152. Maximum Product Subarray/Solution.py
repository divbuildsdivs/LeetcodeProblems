class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        result = nums[0]
        leftProd = 1
        rightProd =1
        N = len(nums)

        for i in range(N):
            if leftProd == 0:
                leftProd = 1
            if rightProd == 0:
                rightProd = 1
            leftProd *= nums[i]
            rightProd *= nums[N-i-1]

            result = max(result, leftProd, rightProd)
        return result