class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col,-1);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(col[i] != -1){
                continue;
            }
            q.offer(i);
            col[i] = 0;
            while(!q.isEmpty()){
            int curr = q.poll();
            for(int g : graph[curr]){
                if(col[g] == -1){
                    col[g] = 1 - col[curr];
                    q.add(g);
                }else if(col[g] == col[curr]){
                    return false;
                }
            }
        }
        }
        
        return true;
    }
}