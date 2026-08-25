class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> q = new LinkedList<>();
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f : flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        q.add(new int[]{0,src,0});
        dist[src] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int v = cur[1];
            int steps = cur[0];
            int currCost = cur[2];
            if(steps > k) continue;
            for(int[] it : adj.get(v)){
               int node = it[0];
               int cost = it[1];
               if(dist[node] > currCost + cost){
                dist[node] = currCost + cost;
                q.add(new int[]{steps + 1 , node , dist[node]});
               }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}