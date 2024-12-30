class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int curr = 1;
        for (int num : nums) {
            curr *= num;

            max1 = Math.max(max1, curr);

            if (curr == 0) {
                curr = 1;
            }
        }
        
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            curr *= nums[i];

            max2 = Math.max(max2, curr);

            if (curr == 0) {
                curr = 1;
            }
        }

        return Math.max(max1, max2);
    }
}