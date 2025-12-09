class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_VAL = 100_000;

    public int specialTriplets(int[] nums) {
        int[] left = new int[MAX_VAL + 1];
        int[] right = new int[MAX_VAL + 1];

        for (int num : nums) {
            right[num]++;
        }

        long ans = 0;

        for (int num : nums) {
            right[num]--;
            long target = num * 2L;

            if (target <= MAX_VAL) {
                int t = (int)target;
                ans += 1L * left[t] * right[t];

                ans %= MOD;
            }

            left[num]++;
        }

        return (int)ans;
    }
}