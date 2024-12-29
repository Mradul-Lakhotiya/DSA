class Solution {
    public int maxProfit(int[] prices) {
        int[] rightMin = new int[prices.length];
        int profit = 0;

        rightMin[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            rightMin[i] = Math.min(rightMin[i - 1], prices[i]);

            profit = Math.max(profit, prices[i] - rightMin[i]);
        }

        return profit;
    }
}