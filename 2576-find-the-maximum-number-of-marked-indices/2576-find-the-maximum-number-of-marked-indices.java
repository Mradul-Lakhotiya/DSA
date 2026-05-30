class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int res = 0;
        int n = nums.length;;

        Arrays.sort(nums);

        for (int i = n - n / 2; i < n; i++) {
            res += (2 * nums[res] <= nums[i] ? 1 : 0);
        }

        return 2 * res;
    }
}