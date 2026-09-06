class Solution {
    char[] s1;
    char[] s2;
    int n;
    int m;
    int[][] dp;

    public int numDistinct(String s, String t) {
        s1 = s.toCharArray();
        s2 = t.toCharArray();

        n = s.length();
        m = t.length();

        dp = new int[n][m];

        for (int[] x : dp) {
            Arrays.fill(x, -1);
        } 

        return helper(0, 0);    
    }

    int helper(int i, int j) {
        if (j == m) {
            return 1;
        }
        else if (i == n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if (s1[i] == s2[j]) {
            dp[i][j] = helper(i + 1, j + 1) + helper(i + 1, j);
        }
        else {
            dp[i][j] = helper(i + 1, j);
        }

        return dp[i][j];
    }
}