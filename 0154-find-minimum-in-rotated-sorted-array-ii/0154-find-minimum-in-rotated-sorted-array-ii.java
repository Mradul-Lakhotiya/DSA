class Solution {
    public int findMin(int[] nums) {
        int min = 5001;

        for (int x : nums) {
            min = Math.min(min, x);
        }

        return min;
    }
}