class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int len = wordList.get(0).length();

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(beginWord);
        vis.add(beginWord);

        int res = 1;

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                String curr = q.poll();

                if (curr.equals(endWord)) {
                    return res;
                }

                for (int j = 0; j < len; j++) {
                    char[] arr = curr.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                        String nxt = new String(arr);

                        if (set.contains(nxt) && !vis.contains(nxt)) {
                            q.add(nxt);
                            vis.add(nxt);
                        }
                    }
                }
            }

            res++;
        }

        return 0;
    }
}