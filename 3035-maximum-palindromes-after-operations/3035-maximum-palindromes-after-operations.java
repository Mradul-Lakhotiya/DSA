class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] freq = new int[26];
        int[] len = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            len[i] = words[i].length();

            for (char c : words[i].toCharArray()) {
                freq[c - 'a']++;
            }
        }

        int pairs = 0;
        for (int f : freq) {
            pairs += f / 2;
        }

        Arrays.sort(len);

        int ans = 0;

        for (int l : len) {
            int need = l / 2;

            if (pairs < need) {
                break;
            }

            pairs -= need;
            ans++;
        }

        return ans;
    }
}