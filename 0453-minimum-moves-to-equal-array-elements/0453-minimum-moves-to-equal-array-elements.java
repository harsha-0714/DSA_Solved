class Solution {
    public int minMoves(int[] nums) {
        int moves = 0 , min = Integer.MAX_VALUE ;
        for(int n : nums){
            min = Math.min(n,min);
        }
        for(int n : nums){
            moves += n - min;
        }
        return moves;
    }
}