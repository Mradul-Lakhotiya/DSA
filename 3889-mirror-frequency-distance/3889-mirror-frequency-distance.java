class Solution {
    public int mirrorFrequency(String s) {
        int[] freq = new int[257];
        boolean[] taken = new boolean[257];
        int res = 0;

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (char c : s.toCharArray()) {
            if (taken[c]) continue;

            char m;

            if (Character.isDigit(c)) {
                m = (char) ('9' - (c - '0'));
            } else {
                m = (char) ('z' - (c - 'a'));
            }

            res += Math.abs(freq[c] - freq[m]);

            taken[c] = true;
            taken[m] = true; 
        }

        return res;
    }
}