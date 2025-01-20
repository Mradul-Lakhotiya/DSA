class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int numRows = mat.length;
        int numCols = mat[0].length;

        Map<Integer, Pair<Integer, Integer>> numToPos = new HashMap<>();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {

                int val = mat[row][col];
                numToPos.put(val, new Pair(row, col));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            Pair<Integer, Integer> pos = numToPos.get(num);
            int row = pos.getKey();
            int col = pos.getValue();

            mat[row][col] = -mat[row][col];

            if (checkRow(row, mat) || checkCol(col, mat)) {
                return i;
            }
        }

        return -1;
    }

    private boolean checkRow(int row, int[][] mat) {
        
        for (int col = 0; col < mat[0].length; col++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        
        return true;
    }

    private boolean checkCol(int col, int[][] mat) {

        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }

        return true;
    }
}