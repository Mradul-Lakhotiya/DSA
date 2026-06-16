class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int maxLen = 0;
        int curr = 1;
        int n = nums.size();
        int prev = 0;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                curr++;
            }
            else {
                prev = curr;
                curr = 1;
            }
            
            maxLen = Math.max(maxLen, curr / 2);
            maxLen = Math.max(maxLen, Math.min(prev, curr));
        }

        return maxLen;
    }
}