class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = min;i<=max;i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}