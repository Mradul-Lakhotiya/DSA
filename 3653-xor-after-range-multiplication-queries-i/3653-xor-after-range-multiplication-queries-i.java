class Solution {
    private static int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length;

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            for (int j = l; j <= r; j += k) {
                nums[j] = (int)((nums[j] * (long)v) % MOD);
            }
        }

        int res = nums[0];
        for (int i = 1; i < n; i++) {
            res = nums[i] ^ res;
        }

        return res;
    }
}