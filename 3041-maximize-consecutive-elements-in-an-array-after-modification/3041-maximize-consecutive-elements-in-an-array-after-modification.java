class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int curr : nums){
            map.put(curr + 1 , map.getOrDefault(curr , 0)+1);
            map.put(curr , map.getOrDefault(curr - 1 , 0) +1);
            res = Math.max(res , Math.max(map.get(curr) , map.get(curr+1)));
        }
        return res;
    }
}