class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        res = 1
        for j in range(1,len(nums)):
            if nums[j] != nums[res-1]:
                nums[res] = nums[j]
                res+=1
        return res 