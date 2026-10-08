class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int diff = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(diff > 0) ans.append(ch);
                diff++;
            }else{
                diff--;
                if(diff > 0) ans.append(ch);
            }
        }
        return ans.toString();
    }
}