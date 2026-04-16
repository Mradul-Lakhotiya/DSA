class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        if (list.size() < 3) {
            return -1;
        }

        int res = 0;
        for (int i = 0; i < 3; i++) {
            res += list.get(i);
        }

        return res;
    }   
}