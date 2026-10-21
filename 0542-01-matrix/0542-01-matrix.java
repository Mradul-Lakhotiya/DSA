class Solution {
    int[][] grid;
    int n, m;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int[][] updateMatrix(int[][] mat) {
        this.grid = mat;
        this.n = mat.length;
        this.m = mat[0].length;

        bfs();

        return grid;
    }

    private void bfs() {
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
                else {
                    grid[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (isValid(nx, ny)) {
                    grid[nx][ny] = grid[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return;
    }

    boolean isValid(int nx, int ny) {
        return (nx >= 0 && ny >= 0 &&
                nx < n && ny < m &&
                grid[nx][ny] == -1);
    }
}