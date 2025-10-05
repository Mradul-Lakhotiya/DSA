class Solution {
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return ans;
        }

        m = heights.length;
        n = heights[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean pacific = canReachPacific(heights, i, j, new boolean[m][n]);
                boolean atlantic = canReachAtlantic(heights, i, j, new boolean[m][n]);

                if (pacific && atlantic) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private boolean canReachPacific(int[][] h, int i, int j, boolean[][] visited) {
        if (i == 0 || j == 0) {
            return true;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (isValid(x, y) && !visited[x][y] && h[x][y] <= h[i][j]) {
                if (canReachPacific(h, x, y, visited)) return true;
            }
        }

        return false;
    }

    private boolean canReachAtlantic(int[][] h, int i, int j, boolean[][] visited) {
        if (i == m - 1 || j == n - 1) return true; // Atlantic edges (bottom or right)
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (isValid(x, y) && !visited[x][y] && h[x][y] <= h[i][j]) {
                if (canReachAtlantic(h, x, y, visited)) return true;
            }
        }

        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
