class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        int ans = 0;

        for (int[] g : guards) {
            grid[g[0]][g[1]] = 'G';
        }

        for (int[] w : walls) { 
            grid[w[0]][w[1]] = 'W';
        }

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] g : guards) {
            int r = g[0];
            int c = g[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                while (nr >= 0 && nr < m && nc >= 0 && nc < n) {

                    if (grid[nr][nc] == 'G' || grid[nr][nc] == 'W') {
                        break;
                    } 

                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = 'X';
                    }

                    nr += d[0];
                    nc += d[1];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) ans++;
            }
        }

        return ans;
    }
}
