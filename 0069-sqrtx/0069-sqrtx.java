class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int h = x;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } 
            else if (square > x) {
                h = mid - 1;
            } 
            else {
                l = mid + 1;
            }
        }

        return l - 1;
    }
}