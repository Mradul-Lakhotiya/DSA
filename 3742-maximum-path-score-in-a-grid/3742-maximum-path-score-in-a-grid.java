class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        int startCost = grid[0][0] > 0 ? 1 : 0;
        if (startCost <= k) {
            dp[0][0][startCost] = grid[0][0];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) {
                        continue;
                    }

                    if (i + 1 < n) {
                        int newCost = c + (grid[i + 1][j] > 0 ? 1 : 0);
                        if (newCost <= k) {
                            dp[i + 1][j][newCost] = Math.max(
                                dp[i + 1][j][newCost],
                                dp[i][j][c] + grid[i + 1][j]
                            );
                        }
                    }

                    if (j + 1 < m) {
                        int newCost = c + (grid[i][j + 1] > 0 ? 1 : 0);
                        if (newCost <= k) {
                            dp[i][j + 1][newCost] = Math.max(
                                dp[i][j + 1][newCost],
                                dp[i][j][c] + grid[i][j + 1]
                            );
                        }
                    }
                }
            }
        }

        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[n - 1][m - 1][c]);
        }

        return ans;
    }
}