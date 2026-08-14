class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = new int[image.length][];
        for(int i = 0;i<image.length;i++){
            ans[i] = image[i].clone();      
        }
        int org = image[sr][sc];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        dfs(ans,sr,sc,color,dir,org);
        return ans;
    }
    private void dfs(int[][] ans , int i , int j , int color,int[][] dir , int org){
        ans[i][j] = color;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && r < ans.length && c >=0 && c < ans[0].length && ans[r][c] == org && ans[r][c] != color){
                dfs(ans,r,c,color,dir,org);
            }
        }
    }
}