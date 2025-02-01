class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;

        if (n == 2) {
            if (nums[n - 1] % 2 == nums[0] % 2) {
                return false;
            }
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                return false;
            }
            
            if (nums[i + 1] % 2 == nums[i] % 2) {
                return false;
            }
        }

        return true;
    }
}