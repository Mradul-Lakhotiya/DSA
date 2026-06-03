class Solution {
    public int largestValsFromLabels(
        int[] values,
        int[] labels,
        int numWanted,
        int useLimit
    ) {

        int n = values.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        Map<Integer, Integer> count = new HashMap<>();

        int ans = 0;
        int taken = 0;

        for (int[] item : arr) {

            int value = item[0];
            int label = item[1];

            if (count.getOrDefault(label, 0) < useLimit) {

                ans += value;

                count.put(label,
                    count.getOrDefault(label, 0) + 1);

                taken++;

                if (taken == numWanted)
                    break;
            }
        }

        return ans;
    }
}