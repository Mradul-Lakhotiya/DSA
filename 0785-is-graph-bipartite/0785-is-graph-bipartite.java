class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];

        Arrays.fill(col, -1);

        for (int i = 0; i < n; i++) {
            if (col[i] != -1) {
                continue;
            } 

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            col[i] = 0;

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int nxt : graph[curr]) {
                    if (col[nxt] == -1) {
                        col[nxt] = 1 - col[curr];
                        q.offer(nxt);
                    }
                    else if (col[nxt] == col[curr]) {
                        return false;
                    }
                }
            }
        }   

        return true;
    }
}