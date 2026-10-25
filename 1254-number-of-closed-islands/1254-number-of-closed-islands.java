class Solution {
    int n, m;
    boolean[][] vis;
    int[][] grid;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int closedIsland(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.vis = new boolean[n][m];
        this.grid = grid;

        for (int i = 0; i < n; i++) {
            if (isValid(i, 0)) {
                vis[i][0] = true;
                dfs(i, 0);
            }

            if (isValid(i, m - 1)) {
                vis[i][m - 1] = true;
                dfs(i, m - 1);
            }
        }

        for (int j = 0; j < m; j++) {
            if (isValid(0, j)) {
                vis[0][j] = true;
                dfs(0, j);
            }

            if (isValid(n - 1, j)) {
                vis[n - 1][j] = true;
                dfs(n - 1, j);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isValid(i, j)) {
                    vis[i][j] = true;
                    dfs(i, j);
                    res++;
                }
            }
        }

        return res;
    }

    void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny)) {
                vis[nx][ny] = true;
                dfs(nx, ny);
            }
        }

        return;
    }

    boolean isValid(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && 
                nx < n && ny < m &&
                grid[nx][ny] == 0 &&
                !vis[nx][ny]);
    }
}