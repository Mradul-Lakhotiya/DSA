class Solution {
    static final int MOD = 1_000_000_007;

    List<Integer>[] tree;
    int[] depth;
    int[][] up;
    int LOG;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        tree = new ArrayList[n + 1];
        depth = new int[n + 1];
        up = new int[n + 1][LOG];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1, 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int dist = distance(u, v);

            ans[i] = dist == 0
                    ? 0
                    : (int) modPow(2, dist - 1, MOD);
        }

        return ans;
    }

    void dfs(int node, int parent) {
        up[node][0] = parent;

        for (int j = 1; j < LOG; j++) {
            up[node][j] = up[up[node][j - 1]][j - 1];
        }

        for (int nei : tree[node]) {
            if (nei != parent) {
                depth[nei] = depth[node] + 1;
                dfs(nei, node);
            }
        }
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = LOG - 1; j >= 0; j--) {
            if (((diff >> j) & 1) == 1) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }

    int distance(int u, int v) {
        int lca = lca(u, v);
        return depth[u] + depth[v] - 2 * depth[lca];
    }

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
}