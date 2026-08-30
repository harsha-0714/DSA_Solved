class Solution {
    public int minCostConnectPoints(int[][] points) {
       int n = points.length , res = 0;
       boolean[] vis = new boolean[n];
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
       Map<Integer,Integer> map = new HashMap<>();
       pq.offer(new int[]{0,0});
       while(!pq.isEmpty()){
        int[] curr = pq.poll();
        int point = curr[0];
        int cost = curr[1];
        if(vis[point]) continue;
        vis[point] = true;
        res += cost;
        for(int it = 0;it<n;it++){
            if(!vis[it]){
                int dist = Math.abs(points[point][0] - points[it][0]) + Math.abs(points[point][1] - points[it][1]);
                if(dist < map.getOrDefault(it,Integer.MAX_VALUE)){
                    map.put(it,dist);
                    pq.offer(new int[]{it,dist});
                }
            }
        }
       } 
       return res;
    }
}