class Solution {
    public int minJumps(int[] arr) {
       int n = arr.length;

        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        boolean[] vis = new boolean[n];
        int res = 0;

        while (!curr.isEmpty()) {
            List<Integer> next = new ArrayList<>();

            for (int node : curr) {
                if (node == n - 1) {
                    return res;
                }

                for (int child : map.get(arr[node])) {
                    if (!vis[child]) {
                        vis[child] = true;
                        next.add(child);
                    }
                }

                map.get(arr[node]).clear();

                if (node + 1 < n && !vis[node + 1]) {
                    vis[node + 1] = true;
                    next.add(node + 1);
                }

                if (node - 1 >= 0 && !vis[node - 1]) {
                    vis[node - 1] = true;
                    next.add(node - 1);
                }
            }

            curr = next;
            res++;
        }

        return -1;
    }
}