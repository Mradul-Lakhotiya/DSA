class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int maxTime = neededTime[0];

        for (int i = 1; i < neededTime.length; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                ans += Math.min(maxTime, neededTime[i]);
                maxTime = Math.max(neededTime[i], maxTime);
            }
            else {
                maxTime = neededTime[i];
            }
        } 

        return ans;
    }
}