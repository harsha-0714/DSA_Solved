class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0 , l = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.containsKey(ch) && map.get(ch) > 2){
                map.put(s.charAt(l),map.get(s.charAt(l)) -1 );
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            res = Math.max(res , i - l +1);
        }
        return res;
    }
}