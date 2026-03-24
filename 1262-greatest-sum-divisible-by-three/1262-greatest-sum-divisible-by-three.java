class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int x : nums) {
            int[] temp = dp.clone();

            for (int i = 0; i < 3; i++) {
                if (temp[i] == Integer.MIN_VALUE) {
                    continue;
                }

                int newVal = temp[i] + x;
                int mod = (newVal % 3 + 3) % 3;
                dp[mod] = Math.max(newVal, dp[mod]);
            }
        }

        return dp[0];
    }
}