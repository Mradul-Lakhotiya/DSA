class Solution {
    Integer[][] dp;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];
        return helper(0, n - 1, nums) >= 0;
    }

    private int helper(int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int leftPick = nums[i] - helper(i + 1, j, nums);
        int rightPick = nums[j] - helper(i, j - 1, nums);

        return dp[i][j] = Math.max(leftPick, rightPick);
    }
}