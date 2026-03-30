class Solution {
    public int minChanges(int n, int k) {
        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(n));
        StringBuilder s2 = new StringBuilder(Integer.toBinaryString(k));
        int res = 0;

        while (s1.length() > s2.length()) {
            s2.insert(0, '0');
        }

        while (s2.length() > s1.length()) {
            s1.insert(0, '0');
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1' && s2.charAt(i) == '0') {
                res++;
            }
            else if (s1.charAt(i) == '0' && s2.charAt(i) == '1') {
                return -1;
            }
        }

        return res;
    }
}