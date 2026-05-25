class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if (s.charAt(n - 1) == '1') {
            return false;
        }
        
        int[] dp = new int[n]; 
        dp[0] = 1;
        int reach = 0;

        for (int i = 1; i < n; i++) {
            if (i >= minJump && dp[i - minJump] > 0) {
                reach++;
            }

            if (i > maxJump && dp[i - maxJump - 1] > 0) {
                reach--;
            }

            if (s.charAt(i) == '0') {
                dp[i] = reach;
            }
        }

        return dp[n - 1] > 0;
    }
}