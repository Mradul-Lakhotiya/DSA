class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        int MOD = 1_000_000_007;

        for (int i = n - 1; i >= 0; i--) {
            long mask = 1L << i;

            if ((a & mask) != 0 && (b & mask) != 0) {
                continue;
            }
            else if ((a & mask) == 0 && (b & mask) == 0) {
                b |= mask;
                a |= mask;
            }
            else if (a < b && (a & mask) == 0) {
                a |= mask;
                b ^= mask;
            }
            else if (b < a && (b & mask) == 0) {
                b |= mask;
                a ^= mask;
            }
        }

        return (int)(((a % MOD) * (b % MOD)) % MOD);
    }
}