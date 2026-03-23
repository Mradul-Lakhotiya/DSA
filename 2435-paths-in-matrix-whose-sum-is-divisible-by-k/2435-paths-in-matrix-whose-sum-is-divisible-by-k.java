class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = 1_000_000_007;
        long[][][] dp = new long[n][m][k];
        
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 1; i < n; i++) {
            for (int rem = 0; rem < k; rem++) {
                if (dp[i - 1][0][rem] > 0) {
                    int newRem = (rem + grid[i][0]) % k;
                    dp[i][0][newRem] = (dp[i][0][newRem] + dp[i - 1][0][rem]) % MOD;
                }
            }
        }   

        for (int i = 1; i < m; i++) {
            for (int rem = 0; rem < k; rem++) {
                if (dp[0][i - 1][rem] > 0) {
                    int newRem = (rem + grid[0][i]) % k;
                    dp[0][i][newRem] = (dp[0][i][newRem] + dp[0][i - 1][rem]) % MOD;
                }
            }
        }  

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int rem = 0; rem < k; rem++) {
                    int rem1 = (rem + grid[i][j]) % k;
                    dp[i][j][rem1] = (dp[i][j][rem1] + dp[i - 1][j][rem]) % MOD;

                    int rem2 = (rem + grid[i][j]) % k;
                    dp[i][j][rem2] = (dp[i][j][rem2] + dp[i][j - 1][rem]) % MOD;
                }
            }
        }

        return (int)(dp[n - 1][m - 1][0] % MOD);
    }
}