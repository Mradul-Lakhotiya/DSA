class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = -1;
        int r = -1;
        int n = nums.length;
        int min = nums[n - 1];
        int max = nums[0];

        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                l = i;
            }
        }

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                r = i;
            }
        }

        if (r == -1) {
            return 0;
        }

        return r - l + 1;
    }
}