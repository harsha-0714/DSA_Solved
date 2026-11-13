class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long res = 0 , cost = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        int n = nums.length;
        for(int i = n-1,j=n-1 ;i>=0;i--){
            int curr = nums[i];
            int cnt = 1;
            while(!dq.isEmpty() && dq.peekLast()[0] < curr){
                int[] prev = dq.pollLast();
                cnt += prev[1];
                cost += (long) (curr - prev[0]) * prev[1];
            }
            dq.offerLast(new int[]{curr , cnt});
            while(cost > k){
                int[] front = dq.pollFirst();
                cost -= (long) (front[0] - nums[j]);
                j--;
                if(front[1] > 1){
                    dq.offerFirst(new int[]{front[0] , front[1]-1});
                }
            }
            res += j - i + 1;
        }
        return res;
    }
}