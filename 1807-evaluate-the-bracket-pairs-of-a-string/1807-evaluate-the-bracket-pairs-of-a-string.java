class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> li : knowledge){
            map.put(li.get(0) , li.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0 , n = s.length();
        while(i < n){
            char ch = s.charAt(i);
            if(ch == '('){
                ++i;
                StringBuilder key = new StringBuilder();
                while(i < n && s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    i++;
                }
                if(map.containsKey(key.toString())){
                    sb.append(map.get(key.toString()));
                }else{
                    sb.append("?");
                }
            }else{
                sb.append(ch);
            }
            i++;
        }
        return sb.toString();
    }
}