class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = Integer.MAX_VALUE;
        int res = 0;

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            int val = helper(nums, mid);

            if (val <= threshold) {
                r = mid - 1;
                res = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return res;
    }

    private int helper(int[] arr, int d) {
        int res = 0;

        for (int x : arr) {
            res += ((x + d  - 1)/ d);
        }

        return res;
    }
}