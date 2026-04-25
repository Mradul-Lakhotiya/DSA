class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        long newN = n;
        if (n < 0) {
            newN = -newN;
            x = 1 / x;
        }

        if (n % 2 == 0) {
            return myPow(x * x, (int)(newN / 2));
        }
        else {
            return x * myPow(x, (int)(newN - 1));
        }
    }
}