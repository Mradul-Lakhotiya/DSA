class Solution {
    List<Integer>[] adj;
    int n;
    int[] dp;

    public long weightedSum(int[] parent, int[] nums) {
        n = parent.length;
        adj = new ArrayList[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        } 

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                continue;
            }

            adj[parent[i]].add(i);
        }

        int h = depth(0, 0);
        long res = 0;

        for (int i = 0; i < n; i++) {
            res += ((long)nums[i] * (h - (long)dp[i] + 1));
        }

        return res;
    }

    int depth(int i, int d) {
        int max = d;

        for (int x : adj[i]) {
            dp[x] = d + 1;
            max = Math.max(max, depth(x, d + 1)); 
        }

        return max;
    }
}