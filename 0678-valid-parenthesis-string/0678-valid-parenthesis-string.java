class Solution {
    char[] s;
    int n;
    Boolean[][] dp;

    public boolean checkValidString(String s) {
        this.s = s.toCharArray();
        this.n = this.s.length;

        dp = new Boolean[n + 1][n + 1];

        return helper(0, 0);
    }

    boolean helper(int i, int count) {
        if (i == n) {
            return count == 0;
        }

        if (count < 0) {
            return false;
        }

        if (dp[i][count] != null) {
            return dp[i][count];
        }

        boolean ans;

        if (s[i] == ')') {
            ans = helper(i + 1, count - 1);
        }
        else if (s[i] == '(') {
            ans = helper(i + 1, count + 1);
        }
        else {
            ans = helper(i + 1, count + 1)
               || helper(i + 1, count - 1)
               || helper(i + 1, count);
        }

        return dp[i][count] = ans;
    }
}