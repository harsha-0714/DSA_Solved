class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int id = -1;
        for(int i = 0;i<sorted.length;i++){
            if(i == 0 || sorted[i] - sorted[i-1] > limit){
                list.add(new ArrayList<>());
                id++;
            }
            list.get(id).add(sorted[i]);
            map.put(sorted[i],id);
        }
        int[] idx = new int[list.size()];
        for(int i = 0;i<nums.length;i++){
            int curr = map.get(nums[i]);
            nums[i] = list.get(curr).get(idx[curr]);
            idx[curr]++;
        }
        return nums;
    }
}