class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return helper(0, 0, m, n);
    }

    private int helper(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }
        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        return memo[i][j] = helper(i + 1, j, m, n) + helper(i, j + 1, m, n);
    }
}