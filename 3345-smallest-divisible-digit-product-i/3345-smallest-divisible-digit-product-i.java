class Solution {
    public int smallestNumber(int n, int t) {
        for (int i = n; i < 111; i++) {
            if (getDigPr(i) % t == 0) {
                return i;
            }
        }

        return -1;
    }

    int getDigPr(int n) {
        int res = 1;

        while (n > 0) {
            res = res * (n % 10);
            n /= 10;
        }

        return res;
    }
}