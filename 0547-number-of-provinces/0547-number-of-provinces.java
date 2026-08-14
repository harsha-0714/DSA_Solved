class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    list.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(vis,list,i);
            }
        }
        return cnt;
    }
    public void dfs(boolean[] vis,List<List<Integer>> list,int src){
        vis[src] = true;
        for(int i : list.get(src)){
            if(!vis[i]){
                dfs(vis,list,i);
            }
        }
    }
}