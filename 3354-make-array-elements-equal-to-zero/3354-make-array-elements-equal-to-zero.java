class Solution {
    public int countValidSelections(int[] nums) {
        int ans = 0;
        int nonZeros = 0;
        int n = nums.length;

        for (int num : nums) {
            if (num != 0) {
                nonZeros++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {

                if (isValid(nums, nonZeros, i, 1)) {
                    ans++;
                }

                if (isValid(nums, nonZeros, i, -1)) {
                    ans++;
                }
            }
        }
        
        return ans;
    }

    private boolean isValid(int[] nums, int nonZeros, int start, int dir) {
        int n = nums.length;
        int[] temp = nums.clone();

        while (nonZeros > 0 && start >= 0 && start < n) {

            if (temp[start] != 0) {
                temp[start]--;
                dir *= -1;

                if (temp[start] == 0) {
                    nonZeros--;
                }
            }

            start += dir;
        }

        return nonZeros == 0;
    }
}