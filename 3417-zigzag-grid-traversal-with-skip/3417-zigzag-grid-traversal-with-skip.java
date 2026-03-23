class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> res = new ArrayList<>();
        boolean take = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (take) {
                    res.add(grid[i][j]);
                }
                take = !take;
            }
            i++;
            if (i < n) {
                for (int j = m - 1; j >= 0; j--) {
                    if (take) {
                        res.add(grid[i][j]);
                    }
                    take = !take;
                }
            }
        }

        return res;
    }
}