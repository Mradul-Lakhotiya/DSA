class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int n = s.length();
        int j = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;

            while (freq[s.charAt(i) - 'a'] > 2) {
                freq[s.charAt(j) - 'a']--;
                j++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}