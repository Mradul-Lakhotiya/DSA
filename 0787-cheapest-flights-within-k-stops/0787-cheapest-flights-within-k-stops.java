import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            adj[u].add(new int[]{v, price});
        }

        // {cost, node, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{0, src, 0});

        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if (node == dst) {
                return cost;
            }

            if (stops == k + 1) {
                continue;
            }

            for (int[] edge : adj[node]) {
                int next = edge[0];
                int price = edge[1];
                int newCost = cost + price;
                int newStops = stops + 1;

                if (newCost < dist[next][newStops]) {
                    dist[next][newStops] = newCost;
                    pq.offer(new int[]{
                        newCost, next, newStops
                    });
                }
            }
        }

        return -1;
    }
}