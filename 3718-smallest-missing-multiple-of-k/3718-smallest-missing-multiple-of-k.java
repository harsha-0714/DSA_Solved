class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        for(int i = 1;i<102;i++){
            int cur = k * i;
            if(!set.contains(cur)){
                return cur;
            }
        }
        return 0;
    }
}