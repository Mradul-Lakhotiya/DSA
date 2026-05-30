class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for (char ch : s.toCharArray()) {
            sFreq[ch - 'a']++;
        }

        for (char ch : target.toCharArray()) {
            tFreq[ch - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (tFreq[i] > 0) {
                ans = Math.min(ans, sFreq[i] / tFreq[i]);
            }
        }

        return ans;
    }
}