class Solution {
    public int minMoves2(int[] nums) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int elem = nums[n/2];
        for(int a : nums){
            res += Math.abs(elem - a);
        }
        return res;
    }
}