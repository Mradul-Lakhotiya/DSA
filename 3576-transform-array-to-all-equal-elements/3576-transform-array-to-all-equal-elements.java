class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        Long costMake1 = getPairCost(nums, -1);
        Long costMakeMinus1 = getPairCost(nums, 1);

        if (costMake1 != null && costMake1 <= k) {
            return true;
        } 

        if (costMakeMinus1 != null && costMakeMinus1 <= k) {
            return true;
        }

        return false;
    }

    private Long getPairCost(int[] nums, int target) {
        Integer last = null;
        long cost = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (last == null) last = i;
                else {
                    cost += Math.abs(last - i);
                    last = null;
                }
            }
        }

        if (last != null) return null;

        return cost;
    }
}
