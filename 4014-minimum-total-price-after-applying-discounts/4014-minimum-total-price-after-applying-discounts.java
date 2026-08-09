class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        
        int n = prices.length, m = discounts.length;
        int i = n - 1;
        int j = m - 1;
        double res = 0;
        
        while (i >= 0 && j >= 0) {
            res += (prices[i] * ((100 - (double)discounts[j]) / 100));
            i--;
            j--;
        }

        while (i >= 0) {
            res += prices[i];
            i--;
        }

        return res;
    }
}