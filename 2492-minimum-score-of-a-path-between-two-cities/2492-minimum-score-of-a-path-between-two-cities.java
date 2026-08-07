class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] list = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] r : roads){
            int a = r[0];
            int b = r[1];
            int dist = r[2];
            list[a].add(new int[]{b , dist});
            list[b].add(new int[]{a , dist});
        }
        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int city = q.poll();
            for(int[] e : list[city]){
                int nextC = e[0];
                int dist = e[1];
                ans = Math.min(ans,dist);
                if(!vis[nextC]){
                    vis[nextC] = true;
                    q.offer(nextC);
                }
            }
        }
        return ans;
    }
}