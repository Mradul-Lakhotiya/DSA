class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq = new int[256];

        for (char c : word.toCharArray()) {
            freq[c]++;
        }

        int res = 0;

        for (int i = 0; i < 26; i++) {
            if (freq['A' + i] > 0 && freq['a' + i] > 0) {
                res++;
            }
        }

        return res;
    }
}