class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = routes.length;

        for (int i = 0; i < n; i++) {
            for (int x : routes[i]) {
                map
                    .computeIfAbsent(x, k -> new ArrayList<>())
                    .add(i);
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visBus = new HashSet<>();
        Set<Integer> visStop = new HashSet<>();

        for (int bus : map.getOrDefault(source, new ArrayList<>())) {
            q.offerLast(bus);
            visBus.add(bus);
        }

        int res = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int bus = q.pollFirst();

                for (int x : routes[bus]) {
                    if (x == target) {
                        return res;
                    }

                    if (visStop.contains(x)) {
                        continue;
                    }

                    visStop.add(x);

                    for (int nextBus : map.get(x)) {
                        if (!visBus.contains(nextBus)) {
                            visBus.add(nextBus);
                            q.offer(nextBus);
                        }
                    }
                }
            }

            res++;
        }

        return -1;
    }
}