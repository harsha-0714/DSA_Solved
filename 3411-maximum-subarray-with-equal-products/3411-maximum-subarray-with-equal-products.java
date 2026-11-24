class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        long LMT = 25200;
        int ans = 1;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                long prod = 1;
                int g = 0 , l =1;
                boolean flag = true;
                for(int k = i;k<=j;k++){
                    prod *= nums[k];
                    if(prod > LMT){
                        flag = false;
                        break;
                    }
                    g = gcd(g , nums[k]);
                    l = l / gcd(l , nums[k]) * nums[k];
                }
                if(flag && prod == (long) g*l) {
                    ans = Math.max(ans , j - i +1);
                }
            }
        }
        return ans;
    }
    private int gcd(int a  , int b){
        return b == 0 ? a : gcd(b,a%b);
    }
}