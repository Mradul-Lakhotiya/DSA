class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n);
    }

    int helper(int n) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int sqrt = (int) Math.sqrt(n);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= sqrt; i++) {
            min = Math.min(helper(n - (i * i)) + 1, min);
        }

        return dp[n] = min;
    }
}