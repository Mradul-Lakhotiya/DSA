class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        TreeSet<Integer> st = new TreeSet<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                st.add(i);
                ans[i] = 1;
            }
            else {
                ans[i] = -1;

                if (mp.containsKey(rains[i])) {
                    Integer it = st.ceiling(mp.get(rains[i]));

                    if (it == null) {
                        return new int[0];
                    }

                    ans[it] = rains[i];
                    st.remove(it);
                }

                mp.put(rains[i], i);
            }
        }

        return ans;
    }
}