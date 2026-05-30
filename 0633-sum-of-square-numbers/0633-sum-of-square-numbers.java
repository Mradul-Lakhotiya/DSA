class Solution {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            long rem = c - (i * i);

            long root = (long)Math.sqrt(rem);

            if (root * root == rem) {
                return true;
            }
        }

        return false;
    }
}