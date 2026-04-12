class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n + 1][27][27];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        dp[0][26][26] = 0;

        for (int i = 0; i < n; i++) {
            int curr = word.charAt(i) - 'A';

            for (int j = 0; j <= 26; j++) {
                for (int k = 0; k <= 26; k++) {
                    if (dp[i][j][k] == Integer.MAX_VALUE) continue;

                    int val = dp[i][j][k];
                    int cost2 = (k == 26) ? 0 : cal(k, curr);
                    dp[i + 1][j][curr] = Math.min(
                        dp[i + 1][j][curr],
                        val + cost2
                    );

                    int cost1 = (j == 26) ? 0 : cal(j, curr);
                    dp[i + 1][curr][k] = Math.min(
                        dp[i + 1][curr][k],
                        val + cost1
                    );
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j <= 26; j++) {
            for (int k = 0; k <= 26; k++) {
                ans = Math.min(ans, dp[n][j][k]);
            }
        }

        return ans;
    }

    private int cal(int a, int b) {
        int ax = a / 6, ay = a % 6;
        int bx = b / 6, by = b % 6;
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}