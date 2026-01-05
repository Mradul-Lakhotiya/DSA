class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) {
                    count++;
                }
                sum += Math.abs(val);
                min = Math.min(min, Math.abs(val));
            }
        }

        if (count % 2 != 0) {
            sum -= 2 * min;
        }

        return sum;
    }
}