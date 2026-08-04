class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0 , r = nums.length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid+1] > nums[mid]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}