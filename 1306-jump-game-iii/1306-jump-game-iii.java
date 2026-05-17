class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int idx = q.poll();

            if (idx < 0 || idx >= n || vis[idx]) {
                continue;
            }

            if (arr[idx] == 0) {
                return true;
            }

            vis[idx] = true;

            q.offer(idx - arr[idx]);
            q.offer(idx + arr[idx]);
        }

        return false;
    }
}