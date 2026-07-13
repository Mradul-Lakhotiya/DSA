class Solution {
    int n;
    int[] nums;
    Integer[][] dp;

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dp = new Integer[n][n + 1];

        return helper(0, -1);
    }

    int helper(int i, int prevIndex) {
        if (i == n) {
            return 0;
        }

        if (dp[i][prevIndex + 1] != null) {
            return dp[i][prevIndex + 1];
        }

        int pick = 0;

        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            pick = 1 + helper(i + 1, i);
        }

        int skip = helper(i + 1, prevIndex);

        return dp[i][prevIndex + 1] = Math.max(pick, skip);
    }
}