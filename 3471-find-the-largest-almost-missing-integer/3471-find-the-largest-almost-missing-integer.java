class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if(k == 1){
            int max = -1;
            for(int i : nums){
                if(map.get(i) == 1 && i > max){
                    max = i;
                }
            }
            return max;
        }
        if(k == n){
            int max = Integer.MIN_VALUE;
            for(int i : nums){
                max = Math.max(i,max);
            }
            return max;
        }
        if(nums[0] == nums[n-1]){
            return -1;
        }
        if(map.get(nums[0])== 1 && map.get(nums[n-1]) > 1){
            return nums[0];
        }
        if(map.get(nums[n-1])== 1 && map.get(nums[0]) > 1){
            return nums[n-1];
        }
        if(map.get(nums[0]) == 1 && map.get(nums[n-1]) == 1){
            return Math.max(nums[0],nums[n-1]);
        }
        return -1;
    }
}