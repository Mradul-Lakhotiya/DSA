class Solution {
    public int numberOfChild(int n, int k) {
        n--;
        int t = k / n;
        int r = k % n;

        if (t % 2 == 0) {
            return r;
        }
        else {
            return (n - r);
        }
    }
}