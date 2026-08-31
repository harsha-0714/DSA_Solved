class Solution {
    class Uf{
        int[] p;
        int[] rank;
        Uf(int n){
            p = new int[n];
            rank = new int[n];
            for(int i = 0;i<n;i++){
                p[i] = i;
                rank[i] = 1;
            }
        }
        int find(int u){
            if(p[u] == u) return u;
            return find(p[u]);
        }
        void union(int i,int j){
            int r1 = find(i);
            int r2 = find(j);
            if(r1 != r2){
                p[r1] = r2;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        Uf u = new Uf(n);
        int extra = 0;
        for(int[] c : connections){
            int r1 = u.find(c[0]);
            int r2 = u.find(c[1]);
            if(r1 == r2) extra++;
            u.union(r1,r2);
        }
        int cnt = 0;
        for(int i = 0;i<n;i++){
            if(u.find(i) == i){
                cnt++;
            }
        }
        return extra >= cnt-1 ? cnt-1 : -1;
    }
}