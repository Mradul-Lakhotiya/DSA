class Solution {
    int[] dRow = { 0, 0, -1, 1 };
    int[] dCol = { -1, 1, 0, 0 };

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        boolean[][] visited = new boolean[n][m];

        PriorityQueue<Cell> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(new Cell(heightMap[i][0], i, 0));
            pq.offer(new Cell(heightMap[i][m - 1], i, m - 1));
            visited[i][0] = true;
            visited[i][m - 1] = true;
        }

        for (int j = 0; j < m; j++) {
            pq.offer(new Cell(heightMap[0][j], 0, j));
            pq.offer(new Cell(heightMap[n - 1][j], n - 1, j));
            visited[0][j] = true;
            visited[n - 1][j] = true;
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();

            int currI = curr.i;
            int currJ = curr.j;
            int minheight = curr.height;

            for (int dir = 0; dir < 4; dir++) {
                int nextI = currI + dRow[dir];
                int nextJ = currJ + dCol[dir];

                if (isValidCell(nextI, nextJ, n, m) && !visited[nextI][nextJ]) {
                    int nextHeight = heightMap[nextI][nextJ];

                    if (nextHeight < minheight) {
                        ans += (minheight - nextHeight);
                    }

                    pq.offer(new Cell(Math.max(nextHeight, minheight), nextI, nextJ));
                    visited[nextI][nextJ] = true;
                }
            }
        }

        return ans;
    }

    private static class Cell implements Comparable<Cell> {
        int height;
        int i;
        int j;

        public Cell(int height, int i, int j) {
            this.height = height;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.height, other.height);
        }
    }

    private boolean isValidCell(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}