class Solution {
    public String reverseParentheses(String s) {
        StringBuilder curr = new StringBuilder();
        Deque<StringBuilder> dq = new LinkedList<>();
        int i = 0 , n = s.length();
        while(i < n){
            char ch = s.charAt(i);
            if(ch == '('){
                dq.push(curr);
                curr = new StringBuilder();
            }else if(ch == ')'){
                curr.reverse();
                curr = dq.pop().append(curr);
            }else{
                curr.append(ch);
            }
            i++;
        }
        return curr.toString();
    }
}