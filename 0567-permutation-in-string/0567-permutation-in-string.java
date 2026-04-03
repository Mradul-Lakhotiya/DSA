class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int n = s1.length();
        int m = s2.length();

        if  (n > m) {
            return false;
        }

        for (char c : s1.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i = 0; i < n; i++) {
            freq[s2.charAt(i) - 'a']++;
        }

        for (int i = n; i < m; i++) {
            if (check(freq)) {
                return true;
            }

            freq[s2.charAt(i) - 'a']++;
            freq[s2.charAt(i - n) - 'a']--;
        }

        return check(freq);
    }

    private boolean check(int[] freq) {

        for (int x : freq) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    } 
}