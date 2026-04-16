class Solution {
    int n;
    int[] nums;
    Integer[][] dp;
    public int rob(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.dp = new Integer[n][2];

        return helper(0, false);
    }

    private int helper(int i, boolean adjWasRob) {
        if (i == n) {
            return 0;
        }

        int state = adjWasRob ? 1 : 0;

        if (dp[i][state] != null) {
            return dp[i][state];
        }

        if (adjWasRob) {
            return dp[i][state] = helper(i + 1, false);
        }
        else {
            int rob = helper(i + 1, true) + nums[i];
            int not = helper(i + 1, false);

            return dp[i][state] = Math.max(rob, not);
        }
    }
}