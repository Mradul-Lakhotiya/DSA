class Solution {
    int[][] memo;

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        memo = new int[n][n];
        return dp(values, 0, n - 1);
    }

    private int dp (int[] v, int i, int j) {
        if (j < i + 2) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, v[i] * v[k] * v[j] + dp(v, i, k) + dp(v, k, j));
        }

        memo[i][j] = res;
        return res;
    }
}