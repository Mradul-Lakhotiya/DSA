class Solution {
    public int minimizedStringLength(String s) {
        boolean[] there = new boolean[26];
        int res = 0;

        for (char ch : s.toCharArray()) {
            there[ch - 'a'] = true;
        }

        for (boolean x : there) {
            if (x) {
                res++;
            }
        }

        return res;
    }
}