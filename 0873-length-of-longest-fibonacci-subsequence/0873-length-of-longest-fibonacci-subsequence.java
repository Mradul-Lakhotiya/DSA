class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        int maxLen = 0;

        for (int i = 2; i < n; i++) {
            int start = 0;
            int end = i - 1;

            while (start < end) {
                int pairSum = arr[start] + arr[end];

                if (pairSum > arr[i]) {
                    end--;
                }
                else if (pairSum < arr[i]) {
                    start++;
                }
                else {
                    dp[end][i] = dp[start][end] + 1;
                    maxLen = Math.max(dp[end][i], maxLen);
                    end--;
                    start++;
                }
            }
        }
        
        return maxLen == 0 ? 0 : maxLen + 2;
    }
}