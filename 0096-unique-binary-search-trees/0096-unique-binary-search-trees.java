class Solution {
    int[] dp;

    public int numTrees(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 1;
        dp[1] = 1;

        return f(n);
    }

    int f(int n) {
        int res = 0;
        
        if (dp[n] != -1) {
            return dp[n];
        }

        for (int i = 1; i <= n; i++) {
            res += f(i - 1) * f (n - i);
        }

        return dp[n] = res;
    }
}