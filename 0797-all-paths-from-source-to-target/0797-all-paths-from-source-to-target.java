class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(0,res, curr, graph);
        return res;
    }
    private void dfs(int src ,List<List<Integer>> res,List<Integer> curr, int[][] graph){
        if(src == graph.length-1){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i : graph[src]){
            curr.add(i);
            dfs(i,res,curr,graph);
            curr.remove(curr.size()-1);
        }
    }
}