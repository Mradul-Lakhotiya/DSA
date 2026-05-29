class Solution {
    public int minElement(int[] nums) {
        int min = nums[0];

        for (int x : nums) {
            min = Math.min(min, getSum(x));
        }

        return min;
    }

    int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += (n % 10);
            n = n / 10;
        }

        return sum;
    }
}