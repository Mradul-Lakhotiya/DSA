
class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    int n, m;
    int[][] grid;
    int[][] dist;

    public int minimumEffortPath(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> q =
            new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        q.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if (d != dist[r][c]) {
                continue;
            }

            if (r == n - 1 && c == m - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (isValid(nr, nc)) {
                    int effort = Math.max(
                        d,
                        Math.abs(grid[nr][nc] - grid[r][c])
                    );

                    if (effort < dist[nr][nc]) {
                        dist[nr][nc] = effort;
                        q.offer(new int[]{nr, nc, effort});
                    }
                }
            }
        }

        return 0;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
