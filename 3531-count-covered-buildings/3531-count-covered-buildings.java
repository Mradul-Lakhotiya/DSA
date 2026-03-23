class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> col = new HashMap<>();
        int count = 0;

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            row.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            col.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        for (List<Integer> l : row.values()) {
            Collections.sort(l);
        }

        for (List<Integer> l : col.values()) {
            Collections.sort(l);
        }

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            if (
                y > row.get(x).get(0) && 
                y < row.get(x).get(row.get(x).size() - 1) &&
                x > col.get(y).get(0) &&
                x < col.get(y).get(col.get(y).size() - 1)
            ) {
                count++;
            }
        }

        return count;
    }
}