    class Solution {
        long len;
        long k;
        char ans;
        public char processStr(String s, long k) {
            len = 0;
            this.k = k;
            ans = '1';

            for (char ch : s.toCharArray()) {
                if (ch == '*') {
                    if (len > 0) {
                        len--;
                    }
                }
                else if (ch == '%') { }
                else if (ch == '#') {
                    len *= 2;
                }
                else {
                    len++;
                }
            }

            if (k >= len) {
                return '.';
            }

            for (int i = s.length() - 1; i >= 0; i--) {
                if (ans == '1') {
                    helper(s.charAt(i));
                }
                else {
                    return ans;
                }
            }

            return ans;
        }

        void helper(char ch) {
            if (ch == '#') {
                len /= 2;
                if (len > 0) {
                    k = k % len;
                }
            }
            else if (ch == '%') {
                k = len - 1 - k;
            }
            else if (ch == '*') {
                len++;
            }
            else {
                len--;
                if (k == len) {
                    ans = ch;
                    return;
                }
            }
        }
    }