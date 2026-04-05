class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = 0;
        int l = 1, r = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isPossible(piles, mid, h)) {
                res = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return res;
    }

    private boolean isPossible(int[] arr, int k, int h) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];

            count += (x + k - 1) / k;

            if (count > h) {
                return false;
            }
        }

        return true;
    }
}