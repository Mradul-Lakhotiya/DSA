class Solution {
    int n;
    int[] nums;
    boolean[][] dp;
    int totalSum = 0;

    public boolean canPartition(int[] nums) {
        n = nums.length;
        this.nums = nums;

        for (int x : nums) {
            totalSum += x;
        }

        dp = new boolean[n + 1][2 * totalSum + 1];

        dp[n][totalSum] = true;

        // for (int sum = -totalSum; sum >= totalSum; sum++) {
        //     dp[n][sum + toatlSum] = (sum == 0);
        // }

        for (int i = n - 1; i >= 0; i--) {
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                boolean takePlus = false;
                boolean takeMinus = false;

                int plus = sum + nums[i];
                int minus = sum - nums[i];

                if (plus <= totalSum) {
                    takePlus = dp[i + 1][plus + totalSum];
                }

                if (minus >= -totalSum) {
                    takeMinus = dp[i + 1][minus + totalSum];
                }

                dp[i][sum + totalSum] = takePlus || takeMinus;
            }
        }

        return dp[0][totalSum];    
    }

    // boolean helper(int i, int sum) {
    //     if (i == n && sum == 0) {
    //         return true;
    //     }

    //     if (i == n) {
    //         return false;
    //     }

    //     if (dp[i][sum + totalSum] != null) {
    //         return dp[i][sum + totalSum];
    //     }

    //     return dp[i][sum + totalSum] = helper(i + 1, sum + nums[i]) || helper(i + 1, sum - nums[i]);
    // }
}