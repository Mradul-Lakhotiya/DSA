class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;

            if ((a & mask) > 0 && (b & mask) > 0 && (c & mask) == 0) {
                res += 2;
            }
            else if ((a & mask) > 0 && (b & mask) == 0 && (c & mask) == 0) {
                res++;
            }
            else if ((a & mask) == 0 && (b & mask) > 0 && (c & mask) == 0) {
                res++;
            }
            else if ((a & mask) == 0 && (b & mask) == 0 && (c & mask) > 0) {
                res++;
            }
        }

        return res;
    }
}