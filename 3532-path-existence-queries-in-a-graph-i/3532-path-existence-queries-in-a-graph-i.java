class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;
        boolean[] res = new boolean[m];
        int[] con = new int[n];
        int com = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                com++;
            }
            con[i] = com;
        }
        
        int i = 0;
        for (int[] x : queries) {
            res[i++] = con[x[0]] == con[x[1]];
        }

        return res;
    }
}