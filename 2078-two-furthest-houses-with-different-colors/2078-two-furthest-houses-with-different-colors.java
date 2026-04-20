class Solution {
    public int maxDistance(int[] colors) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = colors.length;

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(colors[i], key -> new ArrayList<>()).add(i);
        }

        List<List<Integer>> groups = new ArrayList<>(map.values());
        int diff = Integer.MIN_VALUE;

        for (int i = 0; i < groups.size(); i++) {
            for (int j = i + 1; j < groups.size(); j++) {
                List<Integer> list1 = groups.get(i);
                List<Integer> list2 = groups.get(j);

                for (int a : list1) {
                    for (int b : list2) {
                        diff = Math.max(diff, Math.abs(a - b));
                    }
                }
            }
        }

        return diff;      
    }
}