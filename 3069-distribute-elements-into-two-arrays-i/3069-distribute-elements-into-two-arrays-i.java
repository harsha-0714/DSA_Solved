class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> l1 = new ArrayList<>();
        l1.add(nums[0]);
        int p1 = nums[0];
        List<Integer> l2 = new ArrayList<>();
        int p2 = nums[1];
        l2.add(nums[1]);
        int i = 2;
        while(i < n){
            if(p2 < p1){
                l1.add(nums[i]);
                p1 = nums[i];
            }else{
                l2.add(nums[i]);
                p2 = nums[i];
            }
            i++;
        }
        i = 0;
        int i1 = 0 , i2 = 0;
        while(i < n && i1 < l1.size()){
                res[i++] = l1.get(i1++);
        }
        while(i < n && i2 < l2.size()){
                res[i++] = l2.get(i2++);
        }
        return res;
    }
}