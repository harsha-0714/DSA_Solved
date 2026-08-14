class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        Deque<int[]> q = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d : dir){
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                int t = curr[2]+1;
                if(r >= 0 && c >= 0 && c < grid[0].length && r < grid.length && grid[r][c] == 1){
                    grid[r][c] = 2;
                    time = Math.max(t,time);
                    q.offer(new int[]{r,c,t});
                }
            }
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
}