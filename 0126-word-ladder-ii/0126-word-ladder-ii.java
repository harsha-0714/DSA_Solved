class Solution {
    Map<String, Integer> dist;
    List<List<String>> ans;
    String begin;

    public List<List<String>> findLadders(String beginWord, String endWord,
                                          List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        ans = new ArrayList<>();
        dist = new HashMap<>();
        begin = beginWord;

        if (!set.contains(endWord))
            return ans;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        dist.put(beginWord, 1);

        int len = beginWord.length();
        int target = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            String curr = q.poll();
            int steps = dist.get(curr);

            if (steps >= target)
                continue;

            char[] arr = curr.toCharArray();

            for (int i = 0; i < len; i++) {
                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original)
                        continue;

                    arr[i] = ch;
                    String next = new String(arr);

                    if (!set.contains(next))
                        continue;

                    if (!dist.containsKey(next)) {
                        dist.put(next, steps + 1);
                        q.offer(next);

                        if (next.equals(endWord))
                            target = steps + 1;
                    }
                }

                arr[i] = original;
            }
        }

        if (!dist.containsKey(endWord))
            return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, path);

        return ans;
    }

    private void dfs(String word, List<String> path) {
        if (word.equals(begin)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        int steps = dist.get(word);
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == original)
                    continue;

                arr[i] = ch;
                String prev = new String(arr);

                if (dist.containsKey(prev) &&
                    dist.get(prev) == steps - 1) {

                    path.add(prev);
                    dfs(prev, path);
                    path.remove(path.size() - 1);
                }
            }

            arr[i] = original;
        }
    }
}