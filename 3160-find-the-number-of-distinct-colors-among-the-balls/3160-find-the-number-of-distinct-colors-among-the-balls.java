class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Map<Integer, Integer> colourMap = new HashMap<>();
        Map<Integer, Integer> ballMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int colour = queries[i][1];

            if (ballMap.containsKey(ball)) {
                int prevCol = ballMap.get(ball);
                colourMap.put(prevCol, colourMap.get(prevCol) - 1);

                if (colourMap.get(prevCol) == 0) {
                    colourMap.remove(prevCol);
                }
            }

            ballMap.put(ball, colour);
            colourMap.put(colour, colourMap.getOrDefault(colour, 0) + 1);

            ans[i] = colourMap.size();
        }

        return ans;
    }
}