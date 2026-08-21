class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        char[][] res = new char[n][m];
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i<n;i++){
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(res,board,i,m-1,vis);
            }
             if(!vis[i][0] && board[i][0] == 'O'){
                dfs(res,board,i,0,vis);
            }
        }
        for(int i = 0;i<m;i++){
            if(!vis[0][i] && board[0][i] == 'O'){
                dfs(res,board,0,i,vis);
            }
             if(!vis[n-1][i] && board[n-1][i] == 'O'){
                dfs(res,board,n-1,i,vis);
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(res[i][j] != 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] res , char[][] board,int i,int j,boolean[][] vis){
        res[i][j] = 'O';
        vis[i][j] = true;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r >=0 && c >=0 && r < board.length && c < board[0].length && board[r][c] == 'O' && !vis[r][c]){
                dfs(res,board,r,c,vis);
            }
        }
    }
}