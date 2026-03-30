class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> set = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        String ans = s;

        set.add(s);
        q.offerLast(s);

        while (!q.isEmpty()) {
            String curr = q.poll();

            if (curr.compareTo(ans) < 0) {
                ans = curr;
            }

            char[] arr = curr.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                arr[i] = (char)(((arr[i] - '0' + a) % 10) + '0');
            }

            String addA = new String(arr);
            String rot = curr.substring(curr.length() - b) 
                        + curr.substring(0, curr.length() - b);
            
            if (!set.contains(addA)) {
                q.offerLast(addA);
                set.add(addA);
            }

            if (!set.contains(rot)) {
                q.offerLast(rot);
                set.add(rot);
            }
        }

        return ans;
    }
}