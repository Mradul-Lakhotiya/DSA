class Solution {
    int n;
    int[] cost;
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.n = cost.length;
        dp = new int[n];
        
        Arrays.fill(dp, -1);
        int cost0 = helper(0);
        Arrays.fill(dp, -1);
        int cost1 = helper(1);

        return Math.min(cost0, cost1);
    }

    int helper(int i) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int cost1 = helper(i + 1) + cost[i];
        int cost2 = helper(i + 2) + cost[i];

        return dp[i] = Math.min(cost1, cost2);
    }
}