class Solution {
    public int arrangeCoins(int n) {
        long l = 1, r = n;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            long need = mid * (mid + 1) / 2;

            if (need == n) {
                return (int)mid;
            }
            else if (need < n) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return (int)r;
    }
}