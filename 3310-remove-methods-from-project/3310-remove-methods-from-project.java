class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : invocations){
            map.computeIfAbsent(i[0] , z -> new ArrayList<>()).add(i[1]);
        }
        int[] vis = new int[n];
        dfs(k,map,vis);
        for(int[] i : invocations){
            int u = i[0];
            int v = i[1];
            if(vis[u] == 0 && vis[v] == 1){
                for(int d = 0;d<n;d++){
                    res.add(d);
                }
                return res;
            }
        }
        for(int i = 0;i<n;i++){
            if(vis[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
    private void dfs(int src , HashMap<Integer,List<Integer>> map , int[] vis){
        vis[src] = 1;
        if(!map.containsKey(src)){
            return;
        }
        for(int i : map.get(src)){
            if(vis[i] == 0){
                dfs(i,map,vis);
            }
        }
    }
}