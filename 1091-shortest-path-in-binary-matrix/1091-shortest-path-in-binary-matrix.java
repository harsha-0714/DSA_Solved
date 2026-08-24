class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{0,0 ,1});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int k = curr[2];
            if(i == n-1 && j == n-1){
                return k;
            }
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                if(r >=0 && r < n && c>=0 && c<n && grid[r][c] == 0){
                    q.add(new int[]{r,c,k+1});
                    grid[r][c] = 1;
                }
            }
        }
        return -1;
    }
}