class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];

        for (int num : nums) {
            freq[num]++;
        }

        int j = 0;
        for (int i = 0; i < 3; i++) {
            while (freq[i] != 0) {
                nums[j] = i;
                freq[i]--;
                j++;
            }
        }
    }
}