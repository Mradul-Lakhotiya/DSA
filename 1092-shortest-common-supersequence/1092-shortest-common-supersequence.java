class Solution {
    char[] str1;
    char[] str2;
    int n;
    int m;
    int[][] dp;

    public String shortestCommonSupersequence(String str1, String str2) {
        this.str1 = str1.toCharArray();
        this.str2 = str2.toCharArray();

        this.n = str1.length();
        this.m   = str2.length();

        this.dp = new int[n + 1][m + 1];

        for (int[] x : dp) {
            Arrays.fill(x, -1);
        } 

        int len = getLCS(0, 0);

        int i = 0;
        int j = 0;
        StringBuilder lcs = new StringBuilder();

        while (i < n && j < m) {
            if (this.str1[i] == this.str2[j]) {
                lcs.append(this.str1[i]);
                i++;
                j++;
            } 
            else if (dp[i + 1][j] >= dp[i][j + 1]) {
                i++;
            } 
            else {
                j++;
            }
        }

        StringBuilder ans = new StringBuilder();
        i = 0;
        j = 0;

        for (char c : lcs.toString().toCharArray()) {
            while (str1.charAt(i) != c) {
                ans.append(str1.charAt(i));
                i++;
            }

            while (str2.charAt(j) != c) {
                ans.append(str2.charAt(j));
                j++;
            }

            ans.append(c);
            i++;
            j++;
        }

        while (i < str1.length()) {
            ans.append(str1.charAt(i++));
        }

        while (j < str2.length()) {
            ans.append(str2.charAt(j++));
        }

        return ans.toString();

    }

    int getLCS(int i, int j) {
        if (i == n || j == m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int takeAll = 0;
        if (str1[i] == str2[j]) {
            takeAll = 1 + getLCS(i + 1, j + 1);
        }

        int picki = getLCS(i + 1, j);
        int pickj = getLCS(i, j + 1);

        return dp[i][j] = Math.max(picki, Math.max(pickj, takeAll));
    }
}