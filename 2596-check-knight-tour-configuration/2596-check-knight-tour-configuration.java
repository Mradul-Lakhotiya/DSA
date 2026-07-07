class Solution {
    int[][] dir = {
        {-2, -1},
        {-2,  1},
        {-1, -2},
        {-1,  2},
        { 1, -2},
        { 1,  2},
        { 2, -1},
        { 2,  1}
    };

    public boolean checkValidGrid(int[][] grid) {
        boolean isPossible = false;
        int currEl = 0;
        int[] curr = new int[]{0, 0};

        if (grid[0][0] != 0) {
            return false;
        }

        int max = (grid.length * grid[0].length) - 1;

        while (currEl != max) {
            boolean flag = false;
            for (int[] d : dir) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (isValid(nr, nc, grid) && grid[nr][nc] == currEl + 1) {
                    currEl++;
                    curr[0] = nr;
                    curr[1] = nc;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                return false;
            }
        }

        return true;
    }

    boolean isValid(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length &&
            c >= 0 && c < grid[0].length;
    }
}