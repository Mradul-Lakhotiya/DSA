class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int res = events[0][0];
        int max = 0;
        int prev = 0;

        for (int[] x : events) {
            int diff = x[1] - prev;
            
            if (diff > max) {
                max = diff;
                res = x[0];
            }
            else if (diff == max) {
                res = Math.min(res, x[0]);
            }

            prev = x[1];
        }

        return res;
    }
}