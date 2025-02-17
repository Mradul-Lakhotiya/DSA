class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];

        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }

        return findSequences(freq);
    }

    private int findSequences(int[] freq) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }

            count++;
            freq[i]--;

            count += findSequences(freq);

            freq[i]++;
        }

        return count;
    }
}