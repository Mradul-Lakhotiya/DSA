class Solution {
    int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    int n, m;
    int[][] grid;
    int[][] dist;

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.dist = new int[n][m];

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        int res = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        q.add(new int[]{0, 0, 1});
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if (r == n - 1 && c == m - 1) {
                return d;
            }

            if (dist[r][c] != d) {
                continue;
            }

            for (int i = 0; i < 8; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (isValid(nr, nc)) {
                    if (dist[nr][nc] == 0 || dist[nr][nc] > d + 1) {
                        dist[nr][nc] = d + 1;
                        q.add(new int[]{nr, nc, d + 1});
                    }
                }
            }
        }
        
        return -1;
    }

    boolean isValid(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && 
                nx < n && ny < m &&
                grid[nx][ny] == 0);
    }
}