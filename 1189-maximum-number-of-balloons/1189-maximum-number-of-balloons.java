class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        int min = Integer.MAX_VALUE;

        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : new String("balon").toCharArray()) {
            if (ch == 'l' || ch == 'o') {
                min = Math.min(freq[ch - 'a'] / 2, min);
            }
            else {
                min = Math.min(freq[ch - 'a'], min);
            }
        }

        return min;
    }
}