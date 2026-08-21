class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] col = new int[graph.length];
        Arrays.fill(col,-1);
        for(int i=0;i<graph.length;i++){
            if(col[i] != -1){
                continue;
            }
            if(dfs(graph,col,i,0) == false){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph,int[] col , int node,int c){
        col[node] = c;
        for(int n : graph[node]){
            if(col[n] == -1){
                if(dfs(graph,col,n,1-c) == false){
                    return false;
                }
            }else if(col[n] == c){
                return false;
            }
        }
        return true;
    }
}