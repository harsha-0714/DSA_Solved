class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            g.add(new ArrayList<>());
        }
        int[] inD = new int[numCourses];
        for(int[] e : prerequisites){
            g.get(e[0]).add(e[1]);
            inD[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(inD[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int n : g.get(curr)){
                inD[n]--;
                if(inD[n] ==0){
                    q.add(n);
                }
            }
        }
        return cnt == numCourses;
    }
}