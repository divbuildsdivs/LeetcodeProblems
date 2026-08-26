class Solution:
    def resultArray(self, nums: List[int]) -> List[int]:
        arr1 = []
        arr2 = []
        if len(nums) <= 0:
            return []
     
        for i in range(0, len(nums)):
            l1 = len(arr1)
            l2 = len(arr2)
            if (i != 1) and (i == 0 or arr1[l1 - 1] > arr2[l2-1]):
                arr1.append(nums[i])
            else:
                arr2.append(nums[i])
        return arr1 + arr2