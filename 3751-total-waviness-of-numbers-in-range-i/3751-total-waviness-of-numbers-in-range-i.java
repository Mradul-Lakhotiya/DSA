class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int i = Math.max(num1, 101); i <= num2; i++) {
            ans += getWaves(i);
        }

        return ans;
    }

    int getWaves(int num) {
        char[] s = Integer.toString(num).toCharArray();

        int res = 0;

        for (int i = 1; i < s.length - 1; i++) {
            if ((s[i] > s[i - 1] && s[i] > s[i + 1]) ||
                (s[i] < s[i - 1] && s[i] < s[i + 1])) {
                res++;
            }
        }

        return res;
    }
}