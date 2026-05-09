class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        Stack<int[]> st = new Stack<>();
        int n = arr.length;
        long[] dp = new long[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek()[0] >= arr[i]) {
                st.pop();
            }

            int j = st.isEmpty() ? -1 : st.peek()[1];

            if (j == -1) {
                dp[i] = arr[i] * (i + 1);
            }
            else {
                dp[i] = dp[j] + arr[i] * (i - j);
            }

            st.push(new int[]{arr[i], i});

            dp[i] %= MOD;
            ans = (int)((ans + dp[i]) % MOD);
        }

        return ans;
    }
}