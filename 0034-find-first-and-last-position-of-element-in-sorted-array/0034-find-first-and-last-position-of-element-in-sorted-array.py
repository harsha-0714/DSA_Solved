class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l,r = 0,len(nums)-1
        f = -1
        while l <= r:
            mid = l + (r-l)//2
            if nums[mid] == target:
                f = mid
                r = mid -1
            elif nums[mid] > target :
                r = mid - 1
            else :
                l = mid + 1
        if f == -1:
            return [-1,-1]
        
        l = 0 
        r = len(nums)-1
        e = -1
        while l <= r:
            mid = l + (r-l)//2
            if nums[mid] == target : 
                e = mid
                l = mid +1
            elif nums[mid] > target:
                r = mid-1
            else:
                l = mid + 1
        return [f,e]