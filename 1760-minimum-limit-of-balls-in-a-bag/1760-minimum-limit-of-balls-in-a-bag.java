class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int h = Integer.MAX_VALUE;
        int res = -1;

        while (l <= h) {
            int mid = l + ((h - l) / 2);

            if (isPossible(nums, mid, maxOperations)) {
                h = mid - 1;
                res = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return res;
    }

    boolean isPossible(int[] arr, int k, int maxOps) {
        int ops = 0;

        for (int x : arr) {
            ops += ((x - 1) / k);
        }

        if (ops > maxOps) {
            return false;
        }

        return true;
    } 
}