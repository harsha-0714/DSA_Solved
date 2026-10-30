class Solution {
    static class Edge{
        int to , wt;
        Edge(int to , int wt){
            this.to = to;
            this.wt = wt;
        }
    }
    static class State{
        int node , cnt ;
        long dist;
        State(int node , int cnt , long dist){
            this.node = node;
            this.cnt = cnt;
            this.dist = dist;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<Edge>[] graph = new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int e[] : edges){
            graph[e[0]].add(new Edge(e[1],e[2]));
        }
        long inf = Long.MAX_VALUE;
        long[][] dist = new long[n][k+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dist[i],inf);
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dist,b.dist));
        dist[0][1]=0;
        pq.offer(new State(0,1,0));
        while(!pq.isEmpty()){
            State curr = pq.poll();
            int u = curr.node;
            int c = curr.cnt;
            long d = curr.dist;
            if(d != dist[u][c]) continue;
            for(Edge e : graph[u]){
                int v = e.to;
                int newCnt;
                if(labels.charAt(v) == labels.charAt(u)){
                    newCnt = c + 1;
                }else{
                    newCnt = 1;
                }
                if(newCnt > k) continue;
                long nd = d+ e.wt;
                if(nd < dist[v][newCnt]){
                    dist[v][newCnt] = nd;
                    pq.offer(new State(v,newCnt,nd));
                }
            }
        }
        long ans = inf;
        for(int x = 1;x<=k;x++){
            ans = Math.min(ans,dist[n-1][x]);
        }
        return ans == inf?-1:(int)ans;
    }
}