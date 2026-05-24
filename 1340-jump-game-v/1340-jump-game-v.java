class Solution {
    int n;
    int[] arr;
    int d;
    int[] dp;

    public int maxJumps(int[] arr, int d) {
        this.d = d;
        this.n = arr.length;
        this.arr = arr;
        this.dp = new int[n];

        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, helper(i));
        }

        return res;
    }

    int helper(int curr) {
        if (dp[curr] != 0) {
            return dp[curr];
        }

        int best = 1;

        for (int j = curr + 1; j <= Math.min(n - 1, curr + d); j++) {
            if (arr[curr] <= arr[j]) {
                break;
            }

            best = Math.max(best, 1 + helper(j));
        }

        for (int j = curr - 1; j >= Math.max(0, curr - d); j--) {
            if (arr[curr] <= arr[j]) {
                break;
            }

            best = Math.max(best, 1 + helper(j));
        }

        return dp[curr] = best;
    }
}