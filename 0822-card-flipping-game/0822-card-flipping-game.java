class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        int n = fronts.length;

        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }

        int min = 2100;

        for (int x : fronts) {
            if (!set.contains(x)) {
                min = Math.min(min, x);
            }
        } 

        for (int x : backs) {
            if (!set.contains(x)) {
                min = Math.min(min, x);
            }
        }

        return min == 2100 ? 0 : min;
    }
}