class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indeg = new int[n];
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                g[node].add(i);
                indeg[i]++;
            }
        }

        boolean[] isSafe = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            isSafe[curr] = true;

            for (int neg : g[curr]) {
                indeg[neg]--;

                if (indeg[neg] == 0) {
                    q.offer(neg);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                res.add(i);
            }
        }

        return res;
    }
}