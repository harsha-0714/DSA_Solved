class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            int n = s.length();
            while(idx < n){
            int i = 0,sum = 0;
            while(i < k && idx < n){
                int val = s.charAt(idx) - '0';
                sum += val;
                idx++;
                i++;
            }
            sb.append(sum);
        }
        s = sb.toString();
    }
           return s;
    }
}