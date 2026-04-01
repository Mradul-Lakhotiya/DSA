class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String dir) {
        int n = pos.length;
        Integer[] idx = new Integer[n];
        Deque<Integer> st = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> Integer.compare(pos[a], pos[b]));

        for (int i : idx) {
            if (dir.charAt(i) == 'R') {
                st.offerFirst(i);
            }
            else {
                while (!st.isEmpty() && h[i] > 0) {
                    int top = st.pollFirst();

                    if (h[top] > h[i]) {
                        h[i] = 0;
                        h[top]--;
                        st.offerFirst(top);
                    }
                    else if (h[top] < h[i]) {
                        h[top] = 0;
                        h[i]--;
                    }
                    else {
                        h[top] = 0;
                        h[i] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (h[i] > 0) {
                res.add(h[i]);
            }
        }

        return res;
    }
}