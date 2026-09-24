class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            int curr = 0;
            if(nums[i] < 10){
                curr = nums[i];
            }else{
                curr = sum(nums[i]);
            }
            if(curr == i){
                return i;
            }
        }
        return -1;
    }
    private int sum(int num){
        int res = 0;
        while(num > 0){
            int temp = num % 10;
            res += temp;
            num /= 10;
        }
        return res;
    }
}