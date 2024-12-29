class Solution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }

            int temp = nums[i];
            if (nums[i] < nums[i - 1]) {
                for (int j = i - 2; j >= 0; j--) {
                    if (temp == nums[j]) {
                        return true;
                    }
                }
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }

        return false;
    }
}