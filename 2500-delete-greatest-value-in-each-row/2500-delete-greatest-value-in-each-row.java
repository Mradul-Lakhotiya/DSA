class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int max;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
            reverse(grid[i]);
            // Arrays.sort(grid[i], Collections.reverseOrder());
        }

        // now to find the max in each col
        for (int i = 0; i < grid[0].length; i++) {
            max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(grid[j][i], max);
            }
            res += max;
        }

        return res;
    }

    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}