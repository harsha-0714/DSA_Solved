class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp =new int[m][n];
        for(int j = 0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i =1;i<m;i++){
            for(int j = 0;j<n;j++){
                int up1 = j > 0 ? dp[i-1][j-1]:Integer.MAX_VALUE;
                int up2 = dp[i-1][j];
                int up3 = j < n-1 ? dp[i-1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(up1,Math.min(up2,up3));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            min = Math.min(dp[m-1][i] , min);
        }
        return min;
    }
}