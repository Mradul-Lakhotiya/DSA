class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            
            if (freq[i] == 0) {
                continue;
            }

            if (freq[i] % 2 == 1) {
                ans += freq[i] - 1;
            }
            else {
                ans += freq[i] - 2;
            }
        }

        return n - ans;
    }
}