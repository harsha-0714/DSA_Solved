class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = 1;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i!=0 || j != 0){
                    int top = i > 0 ? dp[i-1][j] : 0;
                    int left = j > 0 ? dp[i][j-1] : 0;
                    dp[i][j] = top + left;
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}