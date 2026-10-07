class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0;
        int max = 0;
        int curr = 0;

        for (int d : differences) {
            curr += d;
            min = Math.min(min, curr);
            max = Math.max(max, curr);

            if (max - min > upper - lower) {
                return 0;
            }
        }

        return (upper - lower) - (max - min) + 1;
    }
}