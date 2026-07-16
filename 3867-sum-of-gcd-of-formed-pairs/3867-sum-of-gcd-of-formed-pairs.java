class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGCD = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            prefixGCD[i] = gcd(max, nums[i]);
        }    

        Arrays.sort(prefixGCD);
        long sum = 0;

        for (int i = 0; i < n / 2; i++) {
            sum += gcd(prefixGCD[i], prefixGCD[n - i - 1]);
        }


        return sum;
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}