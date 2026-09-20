class Solution {
    public int reverseDegree(String s) {
        int[] val = new int[26];
        for(int i = 0;i<26;i++){
            val[i] = 26-i;
        }
        int sum = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            sum += (val[ch-'a']*(i+1));
        }
        return sum;
    }
}