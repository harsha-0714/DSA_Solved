class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new LinkedList<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                dq.push(ch);
            }
            else if(ch == '}'){
                if(!dq.isEmpty() &&dq.peek() == '{'){
                    dq.pop();
                }else{
                    return false;
                }
            }else if(ch == ']'){
                if(!dq.isEmpty() &&dq.peek() == '['){
                    dq.pop();
                }else{
                    return false;
                }
            }else if( ch == ')'){
                if(!dq.isEmpty() &&dq.peek() == '('){
                    dq.pop();
                }else{
                    return false;
                }
            }
        }
        return dq.isEmpty();
    }
}