class Solution {
    int[] coins;
    int[][] memo;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        int i = coins.length - 1;
        memo = new int[coins.length][amount + 1];

        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }

        int val = helper(i, amount);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    int helper(int i, int amt) {
        if (amt == 0) {
            return 0;
        }

        if (i == -1) {
            return Integer.MAX_VALUE;
        }
        
        if (memo[i][amt] != -1) {
            return memo[i][amt];
        }

        int pick1 = helper(i - 1, amt);
        int pick2 = Integer.MAX_VALUE;
        int temp = Integer.MAX_VALUE;

        if (coins[i] <= amt) {
            temp = helper(i, amt - coins[i]);
        }
        
        if (temp != Integer.MAX_VALUE) {
            pick2 = 1 + temp;
        }

        return memo[i][amt] = Math.min(pick1, pick2);
    }
}