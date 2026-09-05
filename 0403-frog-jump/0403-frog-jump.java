class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer,Set<Integer>> map =new HashMap<>();
        for(int s : stones){
            map.put(s,new HashSet<>());
        }
        map.get(0).add(0);
        for(int i = 0;i<n;i++){
            int pos = stones[i];
            Set<Integer> curr = map.get(pos);
            for(int k : curr){
                for(int jump = k-1 ; jump<=k+1;jump++){
                    if(jump > 0 && map.containsKey(pos + jump)){
                        map.get(pos+jump).add(jump);
                    }
                }
            }
        }
        return !map.get(stones[n-1]).isEmpty();
    }
}