import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        list.add(new int[]{n, n - 1});
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        int m = list.size();

        for (int i = 1; i < m; i++) {
            int dist = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i - 1)[1] + dist
            );
        }

        for (int i = m - 2; i >= 0; i--) {
            int dist = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i + 1)[1] + dist
            );
        }

        int ans = 0;
        for (int i = 1; i < m; i++) {
            int leftId = list.get(i - 1)[0];
            int leftH = list.get(i - 1)[1];

            int rightId = list.get(i)[0];
            int rightH = list.get(i)[1];

            int dist = rightId - leftId;

            int peak = (leftH + rightH + dist) / 2;

            ans = Math.max(ans, peak);
        }

        return ans;
    }
}