class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder st = new StringBuilder(s);

        while (st.length() != 2) {
            int n = st.length();
            for (int i = 0; i < n - 1; i++) {
                int sum = ((st.charAt(i) - '0') + (st.charAt(i + 1) - '0')) % 10;
                st.append(sum);
            }

            st.delete(0, n);
        }

        return st.charAt(0) == st.charAt(1);
    }
}
