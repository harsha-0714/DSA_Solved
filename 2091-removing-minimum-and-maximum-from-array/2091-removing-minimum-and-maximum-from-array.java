class Solution {
    public int minimumDeletions(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int n = nums.length , steps = 0;
        steps = Math.max(map.get(max),map.get(min)) + 1;
        steps = Math.min(steps , Math.max(n-map.get(max),n-map.get(min)));
        int both = 0;
        if(map.get(min) < map.get(max)){
            both = map.get(min) + 1 + n - map.get(max);
        }else{
             both = map.get(max) + 1 + n - map.get(min);
        }
        steps = Math.min(steps,both);
        return steps;
    }
}