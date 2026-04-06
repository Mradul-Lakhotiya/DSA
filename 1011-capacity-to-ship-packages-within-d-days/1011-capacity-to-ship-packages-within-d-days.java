class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = Integer.MAX_VALUE;
        int res = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = helper(weights, mid);

            if (val <= days) {
                r = mid - 1;
                res = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return res;
    }

    private int helper(int[] arr, int k) {
        int count = 1;
        int temp = k;

        for (int x : arr) {
            if (x > k) {
                return Integer.MAX_VALUE;
            }

            if (x <= temp) {
                temp -= x;
            } else {
                count++;
                temp = k - x;
            }
        }

        return count;
    }
}