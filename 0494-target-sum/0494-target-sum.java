class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int BASE = 1000;
        int[][] dp = new int[n][2001];

        dp[0][BASE + nums[0]]++;
        dp[0][BASE - nums[0]]++;

        for (int i = 1; i < n; i++) {
            for (int s = 0; s <= 2000; s++) {
                if (s + nums[i] <= 2000) {
                    dp[i][s + nums[i]] += dp[i - 1][s];
                }

                if (s - nums[i] >= 0) {
                    dp[i][s - nums[i]] += dp[i - 1][s];
                }
            }
        }

        if (target < -1000 || target > 1000) {
            return 0;
        }

        return dp[n - 1][BASE + target];
    }
}