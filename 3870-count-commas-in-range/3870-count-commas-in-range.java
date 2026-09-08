class Solution {
    public int countCommas(int n) {
        long res = 0;

        for (long i = 1000; i <= n; i *= 1000) {
            res += (n - i + 1);
        }

        return (int)res;
    }
}