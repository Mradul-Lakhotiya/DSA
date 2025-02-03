class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int inc = 1;
        int dec = 1;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            }
            else if (nums[i] < nums[i - 1]) {
                inc = 1;
                dec++;
            }
            else {
                inc = 1;
                dec = 1;
            }

            ans = Math.max(ans, Math.max(inc, dec));
        }

        return ans;
    }
}