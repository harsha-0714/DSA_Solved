class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length-1 , c = heights[0].length-1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,0});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] vis = new boolean[r+1][c+1];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] == r && curr[1] == c) return curr[2];
            if(vis[curr[0]][curr[1]]) continue;
            vis[curr[0]][curr[1]] = true;
            for(int[] d : dir){
                int i = curr[0] + d[0];
                int j = curr[1] + d[1];
                if(i >=0 && j >=0 && i <= r && j <= c && !vis[i][j]){
                    pq.add(new int[]{i,j,Math.max(curr[2] , Math.abs(heights[curr[0]][curr[1]]-heights[i][j]))});
                    
                }
            }
        }
        return 0;
    }
}