class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int prev1 = 0 , prev2 = 0;
        for(int i = 0;i<n-1;i++){
            int curr = Math.max(prev2 + nums[i] , prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        int max = prev1;
        prev1 = 0 ;
        prev2 = 0;
        for(int i = 1;i<n;i++){
            int curr = Math.max(prev1 , prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(max,prev1);
    }
}