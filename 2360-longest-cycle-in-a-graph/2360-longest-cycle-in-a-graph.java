class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int maxCycle = -1;
        for(int i = 0;i<n;i++){
            if(vis[i]) continue;
            Map<Integer,Integer> map = new HashMap<>();
            int curr = i;
            int step = 0;
            while(curr != -1){
                if(map.containsKey(curr)){
                    int len = step - map.get(curr);
                    maxCycle = Math.max(maxCycle,len);
                    break;
                }
                if(vis[curr]){
                    break;
                }
                vis[curr] = true;
                map.put(curr, step);
                curr = edges[curr];
                step++;
            }
        }
        return maxCycle;
    }
}