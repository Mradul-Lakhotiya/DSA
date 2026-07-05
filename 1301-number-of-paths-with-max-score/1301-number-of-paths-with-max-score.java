class Solution {

    int[][] dir = {
        {-1, 0}, 
        {0, -1},  
        {-1, -1}
    };

    int[][] dpScore;
    int[][] dpWays;
    boolean[][] vis;
    final int MOD = 1_000_000_007;
    List<String> board;

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        int n = board.size();
        dpScore = new int[n][n];
        dpWays = new int[n][n];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dpScore[i], -1);
        }

        helper(n - 1, n - 1);

        if (dpWays[n - 1][n - 1] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{
            dpScore[n - 1][n - 1],
            dpWays[n - 1][n - 1]
        };
    }
    void helper(int r, int c) {

        if (vis[r][c]) return;
        vis[r][c] = true;

        if (r == 0 && c == 0) {
            dpScore[r][c] = 0;
            dpWays[r][c] = 1;
            return;
        }

        int best = -1;
        int ways = 0;

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            int val = isValid(nr, nc);

            if (val == -1) continue;

            helper(nr, nc);

            if (dpWays[nr][nc] == 0)
                continue;

            int cur = dpScore[nr][nc] + val;

            if (cur > best) {
                best = cur;
                ways = dpWays[nr][nc];
            } else if (cur == best) {
                ways = (ways + dpWays[nr][nc]) % MOD;
            }
        }

        dpScore[r][c] = best;
        dpWays[r][c] = ways;
    }

    int isValid(int r, int c) {

        int n = board.size();

        if (r < 0 || c < 0 || r >= n || c >= n) {
            return -1;
        }

        char ch = board.get(r).charAt(c);

        if (ch == 'X') {
            return -1;
        }

        if (ch == 'S' || ch == 'E') {
            return 0;
        }

        return ch - '0';
    }
}