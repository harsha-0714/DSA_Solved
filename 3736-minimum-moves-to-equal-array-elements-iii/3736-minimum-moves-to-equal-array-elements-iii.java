class Solution {
    public int minMoves(int[] nums) {
        int elem = 0;
        for(int a : nums){
            elem = Math.max(a , elem);
        }
        int n = nums.length;
        int moves = 0;
        for(int a : nums){
            moves += (elem - a);
        }
        return moves;
    }
}