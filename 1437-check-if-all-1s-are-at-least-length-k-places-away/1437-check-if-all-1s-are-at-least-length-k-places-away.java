class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        boolean isFirstOne = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (count < k && !isFirstOne) {
                    return false;
                }

                isFirstOne = false;
                count = 0;
            }
            else {
                count++;
            }
        }

        return true;
    }
}