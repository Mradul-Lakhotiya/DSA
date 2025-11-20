class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int ans = 0;
        int n = intervals.length;
        int[] todo = new int[n];

        Arrays.sort(intervals, (a, b) -> a[0] != b [0] ? a[0] - b[0] : b[1] - a[1]);
        Arrays.fill(todo, 2);


        while(--n >= 0) {
            int s = intervals[n][0];
            int e = intervals[n][1];
            int m = todo[n];

            for (int i = s; i < s + m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (todo[j] > 0 & i <= intervals[j][1]) {
                        todo[j]--;
                    }
                }

                ans++;
            }
        }

        return ans;
    }
}