class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int n : nums){
            total += n;
        }
        if(total < x) return -1;
        long target = total - x;
        if(target == 0) return nums.length;
        int n = nums.length;
        int l = 0;
        long sum = 0;
        int len = -1;
        for(int r = 0;r<n;r++){
            sum += nums[r];
            while(sum > target && l <= r){
                sum -= nums[l];
                l++;
            }
            if(sum == target){
                len = Math.max(len,r-l+1);
            }
        }
        return len == -1 ? -1 : n - len;
    }
}