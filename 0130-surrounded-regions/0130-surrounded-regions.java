class Solution {
    char[][] grid;
    boolean[][] vis;
    int n, m;

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public void solve(char[][] board) {
        this.grid = board;
        this.n = board.length;
        this.m = board[0].length;
        this.vis = new boolean[n][m];

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }

    void bfs() {
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O' && !vis[i][0]) {
                vis[i][0] = true;
                q.offer(new int[]{i, 0});
            } 

            if (grid[i][m - 1] == 'O' && !vis[i][m - 1]) {
                vis[i][m - 1] = true;
                q.offer(new int[]{i, m - 1});
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O' && !vis[0][j]) {
                vis[0][j] = true;
                q.offer(new int[]{0, j});
            }

            if (grid[n - 1][j] == 'O' && !vis[n - 1][j]) {
                vis[n - 1][j] = true;
                q.offer(new int[]{n - 1, j});
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (isValid(nx, ny)) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return;
    }


    boolean isValid(int nx, int ny) {
        return (nx >= 0 && ny >= 0 &&
                nx < n && ny < m &&
                !vis[nx][ny] && grid[nx][ny] == 'O');
    }
}