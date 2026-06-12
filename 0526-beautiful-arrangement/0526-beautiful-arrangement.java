class Solution {
    int count = 0;
    int n;
    public int countArrangement(int n) {
        this.n = n;
        helper(1, new boolean[n + 1]);
        return count;
    }

    void helper(int idx, boolean[] taken) {
        if (idx == n + 1) {
            count++;
            return;
        }

        for (int j = 1; j <= n; j++) {
            if (!taken[j] && (j % idx == 0 || idx % j == 0)) {
                taken[j] = true;
                helper(idx + 1, taken);
                taken[j] = false;
            }
        }
    }
}