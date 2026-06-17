class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] prefixmin = new int[n];
        int[] suffixmin = new int[n];
        int ans = Integer.MAX_VALUE;

        prefixmin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixmin[i] = Math.min(prefixmin[i - 1], nums[i]);
        }

        suffixmin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixmin[i] = Math.min(suffixmin[i + 1], nums[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (prefixmin[i] < nums[i] && suffixmin[i] < nums[i]) {
                ans = Math.min(ans, nums[i] + suffixmin[i] + prefixmin[i]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}