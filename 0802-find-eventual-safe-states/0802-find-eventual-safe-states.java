class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        int[] check = new int[n];
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(graph,vis,path,check,i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(check[i] == 1){
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int[][] graph,boolean[] vis,boolean[] path,int[] check,int node){
        vis[node] = true;
        path[node] = true;
        for(int n : graph[node]){
            if(!vis[n]){
                if(dfs(graph,vis,path,check,n)){
                    return true;
                }
            }else if(path[n]){
                    return true;
            }
        }
        path[node] = false;
        check[node] = 1;
        return false;
    }
}