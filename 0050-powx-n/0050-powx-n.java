class Solution {
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            long newN = n;
            newN = -newN;
            x = 1 / x;
            n = (int)newN;
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        else {
            return x * myPow(x, n - 1);
        }
    }
}