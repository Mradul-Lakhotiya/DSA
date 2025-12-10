class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int temp = complexity[0];

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= temp) {
                return 0;
            }
        }

        return (int)fract(n - 1);
    }

    private long fract(int n) {
        if (n < 3) {
            return n;
        }
        long ans = 2L;
        
        for (int i = 3; i < n; i++) {
            ans *= i;
            ans %= MOD;
        }

        return ans;
    }
}