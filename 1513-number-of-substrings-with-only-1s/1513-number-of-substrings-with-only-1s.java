class Solution {
    public int numSub(String s) {
        int MOD = 1_000_000_007;
        long ans = 0;
        long count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
            else {
                ans += ( (count) * (count + 1) ) / 2;
                ans %= MOD;
                count = 0;
            }
        }
        ans += ( (count) * (count + 1) ) / 2;
        ans %= MOD;
        return (int) ans;
    }
}