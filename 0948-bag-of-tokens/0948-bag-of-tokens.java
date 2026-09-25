class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int l = 0, r = n - 1;

        int count = 0;
        int max = 0;

        while (l <= r) {
            if (power >= tokens[l]) {
                count++;
                power -= tokens[l];
                l++;

                max = Math.max(count, max);
            }
            else if (count > 0) {
                power += tokens[r];
                r--;
                count--;
            }
            else {
                break;
            }
        }

        return max;
    }
}