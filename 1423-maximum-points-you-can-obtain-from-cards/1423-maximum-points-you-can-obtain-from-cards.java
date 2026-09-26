class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int c:cardPoints){
            sum += c;
        }
        int n = cardPoints.length;
        int window = n - k;
        int curr = 0 , res = 0;
        for(int r = 0;r<n;r++){
            if(r >= window){
                res = Math.max(res , sum-curr);
                curr -= cardPoints[r-window];
            }
            curr += cardPoints[r];
        }
        res = Math.max(res, sum-curr);
        return res;
    }
}