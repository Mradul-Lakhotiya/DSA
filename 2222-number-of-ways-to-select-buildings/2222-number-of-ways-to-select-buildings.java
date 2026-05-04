class Solution {
    public long numberOfWays(String s) {
        long count1 = 0;
        long count0 = 0;
        long ans = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;
            }
            else {
                count0++;
            }
        }

        long count1Before = 0;
        long count0Before = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ans += (count0Before * count0);
                count1--;
                count1Before++;
            }
            else {
                ans += (count1Before * count1);
                count0--;
                count0Before++;
            }
        }

        return ans;
    }
}