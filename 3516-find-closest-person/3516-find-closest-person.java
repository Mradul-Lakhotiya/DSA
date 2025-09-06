class Solution {
    public int findClosest(int x, int y, int z) {
        if (Math.abs(y - z) == Math.abs(x - z))
            return 0;

        return Math.abs(x - z) > Math.abs(y - z) ? 2 : 1;
    }
}