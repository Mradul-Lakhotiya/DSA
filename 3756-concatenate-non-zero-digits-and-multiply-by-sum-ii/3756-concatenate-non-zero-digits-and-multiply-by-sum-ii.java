class Solution {
    int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int[] prefixSum = new int[n + 1];
        long[] prefixVal = new long[n + 1];
        int[] prefixCount = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefixSum[i + 1] = prefixSum[i] + d;

            if (d != 0) {
                prefixVal[i + 1] = (prefixVal[i] * 10 + d) % MOD;
                prefixCount[i + 1] = prefixCount[i] + 1;
            } else {
                prefixVal[i + 1] = prefixVal[i];
                prefixCount[i + 1] = prefixCount[i];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;

            int len = prefixCount[r] - prefixCount[l];

            long val =
                (prefixVal[r] - (prefixVal[l] * pow10[len]) % MOD + MOD) % MOD;

            long sum = prefixSum[r] - prefixSum[l];

            ans[i] = (int)((val * sum) % MOD);
        }

        return ans;
    }
}