class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = Integer.MAX_VALUE;
        int even = Integer.MAX_VALUE;
        for(int n : nums1){
            if(n % 2 == 0){
                even = Math.min(even,n);
            }else{
                odd = Math.min(odd,n);
            }
        }
        if(odd == Integer.MAX_VALUE){
            return true;
        }
        return odd < even;
    }
}