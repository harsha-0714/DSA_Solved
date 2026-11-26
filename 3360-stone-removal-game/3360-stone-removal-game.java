class Solution {
    public boolean canAliceWin(int n) {
        int rem = 10;
        boolean turn = true;
        while(n >= rem){
            n-= rem;
            rem--;
            turn = !turn;
        }
        return !turn;
    }
}