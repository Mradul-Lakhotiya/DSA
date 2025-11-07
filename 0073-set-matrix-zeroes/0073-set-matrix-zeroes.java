class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] dirs = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        List<Pair<Integer, Integer>> zeros = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(new Pair<>(i, j));
                }
            }
        }

        for (Pair<Integer, Integer> p : zeros) {
            int x = p.getKey();
            int y = p.getValue();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                while (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length) {
                    matrix[nx][ny] = 0;
                    nx += dir[0];
                    ny += dir[1];
                }
            }
        }
    }
}