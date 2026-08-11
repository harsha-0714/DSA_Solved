class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memoFunc(n,dp);
    }
    private int memoFunc(int n , int[] dp){
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = memoFunc(n-1,dp)+memoFunc(n-2,dp);
    }
}