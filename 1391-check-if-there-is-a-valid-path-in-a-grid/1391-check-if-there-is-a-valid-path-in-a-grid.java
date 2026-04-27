class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            if (r == m-1 && c == n - 1) {
                return true;
            }

            for(int d = 0; d < 4; d++) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc]) {
                    continue;
                } 
                    

                if (canGo(grid[r][c], d) && canGo(grid[nr][nc], (d + 2) % 4)) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        return false;
    }

    private boolean canGo(int type, int d) {
        if (type == 1) return d == 1 || d == 3; // right, left
        if (type == 2) return d == 0 || d == 2; // up, down
        if (type == 3) return d == 3 || d == 2; // left, down
        if (type == 4) return d == 1 || d == 2; // right, down
        if (type == 5) return d == 0 || d == 3; // up, left
        if (type == 6) return d == 0 || d == 1; // up, right
        return false;
    }
}