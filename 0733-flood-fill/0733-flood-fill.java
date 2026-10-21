class Solution {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    int n, m, t, color;
    int[][] image;
    boolean[][] vis;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.n = image.length;
        this.m = image[0].length;
        this.image = image;
        this.t = image[sr][sc];
        this.color = color;
        this.vis = new boolean[n][m];

        if (t == color) {
            return image;
        }
        
        vis[sr][sc] = true;
        image[sr][sc] = color;
        bfs(sr, sc);

        return image;
    }

    boolean isValid(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && 
                nx < n && ny < m && 
                image[nx][ny] == t && !vis[nx][ny]);
    }

    void bfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny)) {
                vis[nx][ny] = true;
                image[nx][ny] = color;
                bfs(nx, ny);
            }
        }
    }
}