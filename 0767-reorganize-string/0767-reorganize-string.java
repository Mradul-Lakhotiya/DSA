class Solution {
    public String reorganizeString(String s) {
        int[][] freq = new int[26][2];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a'][1]++;
        }

        for (int i = 0; i < 26; i++) {
            freq[i][0] = i;
        }

        Arrays.sort(freq, (a, b) -> b[1] - a[1]);
        int n = s.length();

        if (freq[0][1] > (n + 1) / 2) {
            return "";
        }

        char[] res = new char[n];
        int idx = 0;

        for (int i = 0; i < 26; i++) {
            char ch = (char)(freq[i][0] + 'a');
            int count = freq[i][1];

            while (count > 0) {
                res[idx] = ch;
                idx += 2;

                if (idx >= n) {
                    idx = 1;
                }

                count--;
            }
        }

        return new String(res);
    }
}