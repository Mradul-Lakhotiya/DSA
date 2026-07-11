class Solution {
    int n;
    int[] nums;
    Boolean[][] dp;
    int totalSum = 0;

    public boolean canPartition(int[] nums) {
        n = nums.length;
        this.nums = nums;

        for (int x : nums) {
            totalSum += x;
        }

        dp = new Boolean[n][2 * totalSum + 1];
        return helper(0, 0);    
    }

    boolean helper(int i, int sum) {
        if (i == n && sum == 0) {
            return true;
        }

        if (i == n) {
            return false;
        }

        if (dp[i][sum + totalSum] != null) {
            return dp[i][sum + totalSum];
        }

        return dp[i][sum + totalSum] = helper(i + 1, sum + nums[i]) || helper(i + 1, sum - nums[i]);
    }
}