class Solution {
    class UF{
        int[] p;
        int[] rank;
        UF(int n){
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
        void merge(int r1 , int r2){
            if(r1 == r2) return;
            if(rank[r1] < rank[r2]){
                int temp = r1;
                r1 = r2;
                r2 = temp;
            }
            p[r2] = r1;
            rank[r1] = Math.max(rank[r1], 1+rank[r2]);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UF uf = new UF(n);
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(isConnected[i][j] == 1){
                    int r1 = uf.find(i);
                    int r2 = uf.find(j);
                    uf.merge(r1,r2);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            set.add(uf.find(i));
        }
        return set.size();
    }
}