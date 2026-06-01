class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int res = 0;

        for (int i = n - 1; i >= 0; ) {
            if (i >= 0) {
                res += cost[i];
                i--;
            }
            if (i >= 0) {
                res += cost[i];
                i--;
            }
            
            i--;
        }

        return res;
    }
}