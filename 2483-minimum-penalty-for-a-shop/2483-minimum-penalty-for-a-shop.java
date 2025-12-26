class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int ans = 0;
        int minPenalty = Integer.MAX_VALUE;

        // for (int i = 0; i <= n; i++) {
        //     int cost = getPenalty(customers, i);

        //     if (cost < currentCost) {
        //         ans = i;
        //         currentCost = cost;
        //     }
        // }

        int[] prefixN = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixN[i + 1] = prefixN[i] + (customers.charAt(i) == 'N' ? 1 : 0);
        }

        int[] suffixY = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixY[i] = suffixY[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        for (int t = 0; t <= n; t++) {
            int penalty = prefixN[t] + suffixY[t];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                ans = t;
            }
        }

        return ans;
    }

    private int getPenalty(String str, int time) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'Y' && i >= time) {
                res++;
            }
            else if (str.charAt(i) == 'N' && i < time) {
                res++;
            }
        }

        return res;
    }
}