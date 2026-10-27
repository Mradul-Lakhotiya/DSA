class Solution {
    int[][] grid;
    int n, m;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0 && !vis[i][j]) {
                    long sum = dfs(i, j, vis);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    long dfs(int x, int y, boolean[][] vis) {
        vis[x][y] = true;
        long res = grid[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny)
                    && grid[nx][ny] != 0
                    && !vis[nx][ny]) {
                res += dfs(nx, ny, vis);
            }
        }

        return res;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}