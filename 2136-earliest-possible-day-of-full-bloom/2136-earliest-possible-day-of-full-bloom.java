class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{plantTime[i], growTime[i]};
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        int d = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            d += arr[i][0];
            res = Math.max(res, d + arr[i][1]);
        }

        return res;
    }
}