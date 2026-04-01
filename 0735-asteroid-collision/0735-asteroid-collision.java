class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int a : asteroids) {
            if (a > 0) {
                st.offerFirst(a);
            }
            else {
                int temp = Math.abs(a);

                while (!st.isEmpty() && st.peekFirst() > 0 && temp != 0) {
                    int temp1 = st.pollFirst();

                    if (temp < temp1) {
                        temp = 0;
                        st.offerFirst(temp1);
                    }
                    else if (temp1 == temp) {
                        temp = 0;
                    }
                }

                if (temp != 0) {
                    st.offerFirst(-temp);
                }
            }
        }

        int[] res = new int[st.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = st.pollLast();
        }

        return res;
    }
}