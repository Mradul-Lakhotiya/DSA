class Solution {
    char[][] grid;
    int n, m;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        if ((n + m - 1) % 2 != 0) {
            return false;
        }

        dp = new Boolean[n][m][n + m];

        return helper(0, 0, 0);
    }

    boolean helper(int i, int j, int count) {
        int curr = (grid[i][j] == '(') ? 1 : -1;
        count += curr;


        if (count < 0) {
            return false;
        }
  
        if (dp[i][j][count] != null) {
            return dp[i][j][count];
        }

        if (i == n - 1 && j == m - 1) {
            return dp[i][j][count] = (count == 0);
        }

        if (i == n - 1) {
            return dp[i][j][count] = helper(i, j + 1, count);
        }

        if (j == m - 1) {
            return dp[i][j][count] = helper(i + 1, j, count);
        }

        return dp[i][j][count] =
            helper(i + 1, j, count) ||
            helper(i, j + 1, count);
    }
}