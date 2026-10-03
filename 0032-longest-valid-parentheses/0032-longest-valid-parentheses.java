class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int open = 0 , close = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') open++;
            else close++;
            if(open == close){
                res = Math.max(res , 2 * close);
            }else if(close > open){
                open = 0;
                close = 0;
            }
        }
        open = 0;
        close = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == '(') open++;
            else close++;
            if(open == close){
                res = Math.max(res , 2 * open);
            }else if(open > close){
                open = 0;
                close = 0;
            }
        }
        return res;
    }
}