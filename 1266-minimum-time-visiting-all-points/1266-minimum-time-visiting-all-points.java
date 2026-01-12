class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int[] curr = new int[2];
        curr = points[0];

        for (int[] p : points) {
            res += Math.max( Math.abs(p[0] - curr[0]), Math.abs(p[1] - curr[1]) );
            curr = p;
        }

        return res;
    }
}