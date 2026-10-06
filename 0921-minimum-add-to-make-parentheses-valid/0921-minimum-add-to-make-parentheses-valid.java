class Solution {
    public int minAddToMakeValid(String s) {
        int st = 0 , add = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st++;
            }else{
                if(st > 0){
                    st--;
                }else{
                    add++;
                }
            }
        }
        return st + add;
    }
}