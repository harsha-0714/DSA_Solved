class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int aSt = helper(arriveAlice , days);
        int aE = helper(leaveAlice , days);
        int bSt = helper(arriveBob , days);
        int bE = helper(leaveBob , days);
        int st = Math.max(aSt , bSt);
        int end = Math.min(aE ,bE);
        return st <= end ? end - st + 1 : 0;
    }
    private int helper(String s , int[] days){
        int m = (s.charAt(0) - '0')*10 + (s.charAt(1)-'0');
        int d = (s.charAt(3) - '0')*10 + (s.charAt(4) -'0');
        int fin = d;
        for(int i = 0;i<m-1;i++){
            fin += days[i];
        }
        return fin;
    }
}