class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] curr = points[0];

        for (int i = 1; i < points.length; i++) {
            if (curr[1] >= points[i][0]) {
                curr[1] = Math.min(curr[1], points[i][1]);
            }
            else {
                res.add(curr);
                curr = points[i];
            }
        }

        res.add(curr);

        return res.size();
    }
}