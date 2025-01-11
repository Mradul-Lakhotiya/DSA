class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();

        if (k > n) {
            return false;
        }

        int[] freq = new int[26];
        int oddCount = 0;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int fre : freq) {
            if (fre % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount > k ? false : true;
    }
}