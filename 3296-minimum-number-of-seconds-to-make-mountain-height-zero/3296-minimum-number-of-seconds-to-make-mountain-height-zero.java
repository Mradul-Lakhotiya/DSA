class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 0;
        long r = (long)1e18;
        long res = r;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (possible(mid, mountainHeight, workerTimes)) {
                res = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return res;
    }

    private boolean possible(long T, int H, int[] arr) {
        long total = 0;

        for (int a : arr) {
            long val = (long)(2 * T / a);
            long x = (long)((-1 + Math.sqrt(1 + 4 * val)) / 2);

            total += x;
            if (total >= H) {
                return true;
            }
        }

        return false;
    }
}