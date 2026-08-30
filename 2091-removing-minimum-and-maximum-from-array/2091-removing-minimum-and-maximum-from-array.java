class Solution {
    public int minimumDeletions(int[] nums) {
        int max = 0 , min = 0;
        int n = nums.length;
        if(n <= 2) return n;
        for(int i = 1;i<n;i++){
            if(nums[max] > nums[i]) max = i;
            if(nums[min] < nums[i]) min = i;
        }
        int left = Math.min(max,min);
        int right = Math.max(max,min);
        int steps = right + 1;
        steps = Math.min(steps,n - left);
        steps = Math.min(steps , left + 1 +  n - right);
        return steps;
    }
}