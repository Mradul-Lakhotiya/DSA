class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int res = 0;
        boolean flip = false;

        for (int i = 0; i < n; i++) {
            if (!flip && nums[i] == 0) {
                flip = true;
                res++;
            }
            else if (flip && nums[i] == 1) {
                res++;
                flip = false;
            }
        }

        return res;
    }
}