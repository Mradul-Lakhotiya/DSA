class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] row = new long[n];
        long[] col = new long[m];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
                sum += grid[i][j];
            }
        }

        if (sum % 2 != 0) {
            return false;
        }

        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp += row[i];

            if (temp == sum / 2) {
                return true;
            }
        }

        temp = 0;
        for (int i = 0; i < m; i++) {
            temp += col[i];

            if (temp == sum / 2) {
                return true;
            }
        }

        return false;   
    }
}