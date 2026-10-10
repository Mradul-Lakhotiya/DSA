class Solution {
    public boolean canFinish(int n, int[][] p) {
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] x : p) {
            adj[x[0]].add(x[1]);
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (!dfs(i, adj, vis, path)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int node, List<Integer>[] adj,
                boolean[] vis, boolean[] path) {

        vis[node] = true;
        path[node] = true;

        for (int nei : adj[node]) {
            if (path[nei]) {
                return false;
            }

            if (!vis[nei]) {
                if (!dfs(nei, adj, vis, path)) {
                    return false;
                }
            }
        }

        path[node] = false;
        return true;
    }
}