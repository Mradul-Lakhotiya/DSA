class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char odd = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);

            if (freq[i] % 2 == 1) {
                odd = ch;
            }

            sb.append(String.valueOf(ch).repeat(freq[i] / 2));
        }

        String temp = sb.toString();
        String temp1 = new StringBuilder(temp).reverse().toString();

        if (odd != 0) {
            return temp + odd + temp1;
        }

        return temp + temp1;
    }
}