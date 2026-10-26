class Solution {
    public int countIslands(int[][] grid, int k) {
        int cnt = 0;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] != 0){
                    long res = dfs(grid,i,j,dir);
                    if(res % k == 0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    private long dfs(int[][] grid  , int i , int j , int[][] dir){
        if(i < 0 || j < 0 || i>=grid.length || j>= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        long curr_sum = grid[i][j];
        grid[i][j] =  0;
        for(int[] d : dir){
            curr_sum += dfs(grid,i+d[0] , j + d[1] , dir);
        }
        return curr_sum;
    }
}