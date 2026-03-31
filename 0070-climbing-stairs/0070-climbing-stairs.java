class Solution {
    int[] memo = new int[50];
    
    public int climbStairs(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1; 
        }

        if (n == 2) {
            return 2;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = helper(n - 1) + helper(n - 2);

        return memo[n];
    }
}