class Solution {
    public boolean isAnagram(String s, String t) {
        int[] help = new int[26];

        for (char ch : s.toCharArray()) {
            help[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            help[ch - 'a']--;
        }

        for (int x : help) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }
}