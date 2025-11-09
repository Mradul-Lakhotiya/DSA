class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int[] freq = new int[n];

        for (int num : nums) {
            freq[num - 1]++;
            if (freq[num - 1] > 1) {
                return num;
            }
        }

        return -1;
    }
}