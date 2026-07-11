class Solution {
    int n;
    int[] nums;
    Boolean[][] dp;
    int totalSum = 0;
    boolean flag = false;

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
            flag = true;
            return true;
        }

        if (i == n) {
            return false;
        }

        if (dp[i][sum + totalSum] != null) {
            return dp[i][sum + totalSum];
        }

        if (flag) {
            return true;
        }

        return dp[i][sum + totalSum] = helper(i + 1, sum + nums[i]) || helper(i + 1, sum - nums[i]);
    }
}