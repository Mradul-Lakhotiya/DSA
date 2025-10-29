class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numZero = 0;
        int prod = 1;
        for (int num : nums) {
            if (num == 0) numZero++;
            else prod *= num;

            if (numZero > 1) break;
        }

        for (int i = 0; i < nums.length; i++) {
            if (numZero > 1) nums[i] = 0;
            else if (numZero == 1 && nums[i] == 0) nums[i] = prod;
            else if (numZero == 1) nums[i] = 0;
            else nums[i] = prod / nums[i];
        }

        return nums;
    }
}