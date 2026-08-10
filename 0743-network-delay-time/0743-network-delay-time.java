class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] t : times){
            list.get(t[0]).add(new int[]{t[1],t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});
        int[] time = new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];
            if(time[node] < dist){
                continue;
            }
            time[node] = dist;
            for(int[] neigh : list.get(node)){
                if(time[neigh[0]] > neigh[1] + dist){
                    pq.add(new int[]{neigh[0] , neigh[1]+dist});
                }
            }
        }
        int max = 0;
        for(int i = 1 ;i<=n;i++){
            if(time[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(time[i],max);
        }
        return max;
    }
}