class Solution {
    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return ans;
    }

    private int solve(
        int[] startA,
        int[] durA,
        int[] startB,
        int[] durB
    ) {

        int m = startB.length;

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = startB[i];
            rides[i][1] = durB[i];
        }

        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        int[] suffixMin = new int[m];

        suffixMin[m - 1] = rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(
                suffixMin[i + 1],
                rides[i][0] + rides[i][1]
            );
        }

        int[] prefixMinDur = new int[m];

        prefixMinDur[0] = rides[0][1];

        for (int i = 1; i < m; i++) {
            prefixMinDur[i] = Math.min(
                prefixMinDur[i - 1],
                rides[i][1]
            );
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < startA.length; i++) {

            int finishA = startA[i] + durA[i];

            int idx = upperBound(rides, finishA);

            // case 1:
            // rides with start <= finishA
            if (idx >= 0) {
                ans = Math.min(
                    ans,
                    finishA + prefixMinDur[idx]
                );
            }

            // case 2:
            // rides with start > finishA
            if (idx + 1 < m) {
                ans = Math.min(
                    ans,
                    suffixMin[idx + 1]
                );
            }
        }

        return ans;
    }

    private int upperBound(int[][] rides, int target) {

        int l = 0;
        int r = rides.length - 1;

        int ans = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (rides[mid][0] <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}