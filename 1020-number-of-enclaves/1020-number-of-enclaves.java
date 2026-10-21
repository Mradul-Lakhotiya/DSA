class Solution {
    int[][] grid;
    boolean[][] vis;
    int n, m;

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int numEnclaves(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.vis = new boolean[n][m];
        this.grid = grid;

        helper();
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    res++;
                }
            }
        }

        return res;
    } 

    boolean isValid(int nx, int ny) {
        return (nx >= 0 && ny >= 0 &&
                nx < n && ny < m &&
                !vis[nx][ny] && 
                grid[nx][ny] == 1);
    }

    void helper() {
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                vis[i][0] = true;
                dfs(i, 0);
            }

            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                vis[i][m - 1] = true;
                dfs(i, m - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1 && !vis[0][i]) {
                vis[0][i] = true;
                dfs(0, i);
            }

            if (grid[n - 1][i] == 1 && !vis[n - 1][i]) {
                vis[n - 1][i] = true;
                dfs(n - 1, i);
            }
        }
    }

    void dfs(int x, int y) {
        vis[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny)) {
                vis[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}