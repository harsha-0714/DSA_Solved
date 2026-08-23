class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        int[] res = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            g.add(new ArrayList<>());
        }
        int[] inD = new int[numCourses];
        for(int[] e : prerequisites){
            g.get(e[1]).add(e[0]);
            inD[e[0]]++;
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
            res[cnt++] = curr;
            for(int n : g.get(curr)){
                inD[n]--;
                if(inD[n] ==0){
                    q.add(n);
                }
            }
        }
        return cnt == numCourses ? res : new int[]{};
    }
}