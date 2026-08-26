class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int ones = 0 , l =0;
        for(int r = 0;r<s.length();r++){
            if(s.charAt(r) == '1'){
                ones++;
            }
            while(ones > k){
                if(s.charAt(l) == '1'){
                    ones--;
                }
                l++;
            }
            while(ones == k && s.charAt(l) == '0'){
                l++;
            }
            if(ones == k){
                String curr = s.substring(l,r+1);
                if(ans.isEmpty() || curr.length() < ans.length() || (curr.length() == ans.length() && curr.compareTo(ans) < 0)){
                    ans = curr;
                }
            }
        }
        return ans;
    }
}