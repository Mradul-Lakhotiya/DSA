class Solution {
    static long modPow(long a, long b, long mod) {
        long res = 1;
        a %= mod;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }

            a = (a * a) % mod;
            b >>= 1;
        }

        return res;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 2;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int max_depth = dfs(1, -1, graph);
        return (int)modPow(2, max_depth - 1, 1_000_000_007);
    }

    int dfs(int node, int parent, List<Integer>[] graph) {
        int depth = 0;

        for (int nei : graph[node]) {
            if (nei != parent) {
                depth = Math.max(depth, 1 + dfs(nei, node, graph));
            }
        }

        return depth;
    }
}