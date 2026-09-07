class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i , j =0, len(numbers)-1
        while i < j :
            cur = numbers[i] + numbers[j]
            if cur == target:
                return [i+1,j+1]
            elif cur < target : 
                i += 1
            elif cur > target :
                j -= 1
        return [-1,-1]