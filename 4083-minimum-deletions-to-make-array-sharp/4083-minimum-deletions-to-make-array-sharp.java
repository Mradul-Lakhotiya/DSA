class Solution {
    public int minDeletions(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int res = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] == prev) {
                res++;
            }
            else {
                prev = nums[i];
            }
        }

        return res;
    }
}