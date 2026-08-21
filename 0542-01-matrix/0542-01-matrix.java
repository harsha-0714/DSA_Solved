class Solution {
    static class Node{
        int f;
        int s;
        int t;
        Node(int f , int s ,int t){
            this.f = f;
            this.s = s;
            this.t = t;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] res = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    q.add(new Node(i,j,0));
                }
            }
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            Node curr = q.poll();
            int i = curr.f;
            int j = curr.s;
            int d = curr.t;
            res[i][j] = d ;
            for(int[] z : dir){
                int r = i + z[0];
                int c = j + z[1];
                if(r>=0 && r<n && c>=0 && c<m && !vis[r][c]){
                    q.add(new Node(r,c,d+1));
                    vis[r][c] = true;
                }
            }
        }
        return res;
    }
}