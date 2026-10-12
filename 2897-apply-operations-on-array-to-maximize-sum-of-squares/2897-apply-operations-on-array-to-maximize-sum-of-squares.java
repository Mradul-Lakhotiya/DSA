class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] bitCount = new int[32];
        long res = 0;

        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                if ((x & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            long curr = 0;

            for (int j = 0; j < 32; j++) {
                if (bitCount[j] > 0) {
                    curr |= 1L << j;
                    bitCount[j]--;
                }
            }

            res = (res + ((curr * curr) % MOD)) % MOD;
        }

        return (int)res;
    }
}