class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < V; i++) {
            set.add(i);
        }

        int res = 0;
        boolean[] visited = new boolean[V];
        
        while (!set.isEmpty()) {
            Queue<Integer> q = new LinkedList<>();
            int curr = set.iterator().next();

            q.offer(curr);

            while (!q.isEmpty()) {
                curr = q.poll();
                visited[curr] = true;
                set.remove(curr);

                for (int i = 0; i < V; i++) {
                    if (!visited[i] && isConnected[curr][i] == 1) {
                        visited[i] = true;
                        set.remove(i);
                        q.offer(i);
                    }
                }
            }

            res++;
        }

        return res;
    }
}