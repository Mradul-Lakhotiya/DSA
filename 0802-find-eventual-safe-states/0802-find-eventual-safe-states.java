class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indeg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                indeg[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        boolean[] isSafe = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            isSafe[node] = true;

            for (int neg : adj.get(node)) {
                indeg[neg]--;
                if (indeg[neg] == 0) {
                    q.add(neg);
                }
            }
        }

        List<Integer> safeNode = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                safeNode.add(i);
            }
        }

        return safeNode;
    }
}