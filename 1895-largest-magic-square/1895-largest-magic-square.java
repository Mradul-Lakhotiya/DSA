class Solution {
    int[][] grid;
    int n, m;

    public int largestMagicSquare(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        int maxK = Math.min(n, m);

        for (int k = maxK; k >= 1; k--) {
            if (isValid(k)) {
                return k;
            }
        }

        return 1;
    }

    boolean isValid(int k) {
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                if (helper(i, j, k)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean helper(int r, int c, int k) {

        int target = 0;

        // first row sum
        for (int j = c; j < c + k; j++) {
            target += grid[r][j];
        }

        // row sums
        for (int i = r; i < r + k; i++) {
            int sum = 0;
            for (int j = c; j < c + k; j++) {
                sum += grid[i][j];
            }
            if (sum != target) return false;
        }

        // column sums
        for (int j = c; j < c + k; j++) {
            int sum = 0;
            for (int i = r; i < r + k; i++) {
                sum += grid[i][j];
            }
            if (sum != target) return false;
        }

        // main diagonal
        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != target) return false;

        // secondary diagonal
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[r + i][c + k - 1 - i];
        }

        return diag2 == target;
    }
}