class Solution {
    int n;
    int[][] pairs;
    int[][] dp;

    public int findLongestChain(int[][] pairs) {
        this.n = pairs.length; 
        dp = new int[n][n + 1];

        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            else {
                return a[0] - b[0];
            }
        });

        this.pairs = pairs;

        return helper(0, -1);
    }

    int helper(int i, int prevIdx) {
        if (i == n) {
            return 0;
        }

        int pick = 0;
        if (dp[i][prevIdx + 1] != -1) {
            return dp[i][prevIdx + 1];
        }

        if (prevIdx == -1 || pairs[prevIdx][1] < pairs[i][0]) {
            pick = 1 + helper(i + 1, i);
        }

        int notPick = helper(i + 1, prevIdx);

        return dp[i][prevIdx + 1] = Math.max(pick, notPick);
    } 
}