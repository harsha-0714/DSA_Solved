class Solution {
    static class Pair{
        String s;
        int n;
        Pair(String s ,int n){
            this.s = s;
            this.n = n;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String w : wordList){
            set.add(w);
        }
        int len = beginWord.length();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.s.equals(endWord)) return curr.n;
            for(int i = 0;i<len;i++){
                for(char ch = 'a';ch<='z';ch++){
                    char[] arr = curr.s.toCharArray();
                    arr[i] = ch;
                    String currWord = new String(arr);
                    if(set.contains(currWord)){
                        set.remove(currWord);
                        q.add(new Pair(currWord,curr.n + 1));
                    }
                }
            }
        }
        return 0;
    }
}