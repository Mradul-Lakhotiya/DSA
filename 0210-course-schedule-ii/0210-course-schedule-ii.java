
class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[1]).add(e[0]);
            inDeg[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[n];
        int idx = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            res[idx++] = cur;

            for (int next : adj.get(cur)) {
                inDeg[next]--;

                if (inDeg[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (idx != n) {
            return new int[0];
        }

        return res;
    }
}
