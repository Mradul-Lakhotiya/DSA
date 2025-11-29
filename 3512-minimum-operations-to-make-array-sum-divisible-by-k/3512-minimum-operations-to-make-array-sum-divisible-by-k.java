class Solution {
    public int minOperations(int[] nums, int k) {
        int  sum = 0;
        
        for (int num : nums) {
            sum += num;
        }

        return (int)(sum % k);
    }
}