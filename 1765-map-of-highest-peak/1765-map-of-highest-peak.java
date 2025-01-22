class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        int row = isWater.length;
        int col = isWater[0].length;

        int[][] res = new int[row][col];

        for (int[] r : res) {
            Arrays.fill(r, -1);
        }

        Queue<int[]> cellQueue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isWater[i][j] == 1) {
                    cellQueue.add(new int[] { i, j });
                    res[i][j] = 0;
                }
            }
        }

        int heightOfNextLayer = 1;

        while (!cellQueue.isEmpty()) {
            int layerSize = cellQueue.size();

            for (int i = 0; i < layerSize; i++) {
                int[] currCell = cellQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int X = currCell[0] + dx[j];
                    int Y = currCell[1] + dy[j];

                    if (isValid(X, Y, row, col) && res[X][Y] == -1) {
                        res[X][Y] = heightOfNextLayer;
                        cellQueue.add(new int[] { X, Y });
                    }
                }   
            }

            heightOfNextLayer++;
        }

        return res;
    }

    public boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}