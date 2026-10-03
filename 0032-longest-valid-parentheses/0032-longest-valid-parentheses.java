class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int bal = 0;
        int lastIdx = -1;
        int maxLen = 0;

        for (int i = 0; i  < n; i++) {
            if (s.charAt(i) == '(') {
                bal++;
            }
            else {
                bal--;
            }

            if (bal < 0) {
                bal = 0;
                lastIdx = i;
            }
            else if (bal == 0) {
                maxLen = Math.max(maxLen, i - lastIdx);
            }
        }

        bal = 0;
        lastIdx = n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                bal++;
            }
            else {
                bal--;
            }

            if (bal < 0) {
                bal = 0;
                lastIdx = i;
            }
            else if (bal == 0) {
                maxLen = Math.max(maxLen, lastIdx - i);
            }
        }

        return maxLen;
    }
}