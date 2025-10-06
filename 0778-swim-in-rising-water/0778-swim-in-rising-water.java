class Solution {
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int swimInWater(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); 
        pq.offer(new int[]{0, 0, grid[0][0]});

        int ans = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int t = curr[2];

            ans = Math.max(ans, t);
            if (x == m - 1 && y == n - 1) return ans;

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (isValid(newX, newY) && !visited[newX][newY]) {
                    pq.offer(new int[]{newX, newY, grid[newX][newY]});
                }
            }
        }

        return -1;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
