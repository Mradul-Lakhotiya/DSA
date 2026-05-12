class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int low = 0;
        int high = (int)1e9;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, tasks)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int energy, int[][] tasks) {
        for (int[] t : tasks) {

            int actual = t[0];
            int minimum = t[1];

            if (energy < minimum) {
                return false;
            }

            energy -= actual;
        }

        return true;
    }
}