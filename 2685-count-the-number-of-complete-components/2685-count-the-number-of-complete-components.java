class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[][] adj = new int[n][n];

        for (int[] e : edges) {
            adj[e[0]][e[1]] = 1;
            adj[e[1]][e[0]] = 1;
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }

            List<Integer> comp = new ArrayList<>();
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            vis[i] = true;

            while (!q.isEmpty()) {
                int u = q.poll();
                comp.add(u);

                for (int v = 0; v < n; v++) {
                    if (adj[u][v] == 1 && !vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }

            int k = comp.size();
            boolean complete = true;

            for (int u : comp) {
                int degree = 0;
                for (int v : comp) {
                    if (adj[u][v] == 1) {
                        degree++;
                    }
                }
                if (degree != k - 1) {
                    complete = false;
                    break;
                }
            }

            if (complete) {
                ans++;
            }
        }

        return ans;
    }
}