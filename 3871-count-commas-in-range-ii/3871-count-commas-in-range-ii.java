class Solution {
    public long countCommas(long n) {
        if(n <= 999) return 0;
        long res = 0;
        long st = 1000;
        while(st <= n){
            res += n - st + 1;
            st *= 1000;
        }
        return res;
    }
}