class Solution {
    public int maxDepth(String s) {
        int curr = 0 , max = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                curr++;
                max = Math.max(max,curr);
            }else if(ch == ')'){
                curr--;
            }
        }
        return max;
    }
}