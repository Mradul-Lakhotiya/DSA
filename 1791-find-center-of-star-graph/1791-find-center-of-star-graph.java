class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] freq = new int[n + 1];

        for (int[] e : edges) {
            freq[e[0]]++;
            freq[e[1]]++;
        }

        for (int i = 0; i < n + 1; i++) {
            if (freq[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}