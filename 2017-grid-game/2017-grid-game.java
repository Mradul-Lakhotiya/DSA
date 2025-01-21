class Solution {
    public long gridGame(int[][] grid) {
        long firstRowSum = 0;
        long secondRowSum = 0;
        long minimumSum = Long.MAX_VALUE;

        for (int g : grid[0]) {
            firstRowSum += g;
        }

        for (int turnIndex = 0; turnIndex < grid[0].length; turnIndex++) {
            firstRowSum -= grid[0][turnIndex];

            minimumSum = Math.min(
                minimumSum,
                Math.max(firstRowSum, secondRowSum)
            );

            secondRowSum += grid[1][turnIndex];
        }

        return minimumSum;
    }
}