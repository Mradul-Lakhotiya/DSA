class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i - 1] >= nums[i]) {
                currSum = nums[i];
            } 
            else {
                currSum += nums[i];
            }

            ans = Math.max(ans, currSum);
        }

        return ans;
    }
}