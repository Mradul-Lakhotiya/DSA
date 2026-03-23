class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = 1_000_000_007;
        long[][] maxDp = new long[n][m];
        long[][] minDp = new long[n][m];
        
        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            maxDp[i][0] = maxDp[i - 1][0] * grid[i][0];
            minDp[i][0] = minDp[i - 1][0] * grid[i][0];
        }
        
        for (int i = 1; i < m; i++) {
            maxDp[0][i] = maxDp[0][i - 1] * grid[0][i];
            minDp[0][i] = minDp[0][i - 1] * grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int val = grid[i][j];

                long a = maxDp[i - 1][j] * val;
                long b = minDp[i - 1][j] * val;
                long c = maxDp[i][j - 1] * val;
                long d = minDp[i][j - 1] * val;

                maxDp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minDp[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        return maxDp[n - 1][m - 1] < 0 ? -1 : (int)(maxDp[n - 1][m - 1] % MOD);
    }
}