class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0.0;
        int prev = 0;

        for (int[] b : brackets) {
            int u = b[0];
            int p = b[1];

            int range = u - prev;
            int tax = Math.min(income, range);

            ans += tax * (p / 100.0);

            income -= tax;
            prev = u;

            if (income == 0) break;
        }

        return ans;
    }
}