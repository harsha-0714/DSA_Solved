class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int i = 0;i<grid.length;i++){
            if(grid[i][0] == 1){
                dfs(grid,i,0,dir);
            }
            if(grid[i][grid[0].length-1] == 1){
                dfs(grid,i,grid[0].length-1,dir);
            }
        }
        for(int i = 0;i<grid[0].length;i++){
            if(grid[0][i] == 1){
                dfs(grid,0,i,dir);
            }
            if(grid[grid.length-1][i] == 1){
                dfs(grid,grid.length-1,i,dir);
            }
        }
        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(int[][] grid , int i , int j , int[][] dir){
        grid[i][j] = 0;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r >=0 && c >=0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                dfs(grid,r,c,dir);
            }
        }
    }
}