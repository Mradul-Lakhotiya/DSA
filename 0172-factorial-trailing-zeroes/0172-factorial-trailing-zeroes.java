class Solution {
    public int trailingZeroes(int n) {
        int tow = 0;
        int five = 0;

        for (int i = 1; i <= n; i++) {
            int temp = i;

            while (temp % 2 == 0) {
                temp /= 2;
                tow++;
            }

            while (temp % 5 == 0) {
                temp /= 5;
                five++;
            }
        }

        return Math.min(tow, five);
    }
}