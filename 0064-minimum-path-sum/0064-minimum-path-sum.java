class Solution {
    int[][] grid;
    int[][] memo;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;

        memo = new int[m][n];

        return helper(m - 1, n - 1);
    }

    private int helper(int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int up = helper(i - 1, j);
        int left = helper(i, j - 1);

        return memo[i][j] = grid[i][j] + Math.min(up, left);
    }
}