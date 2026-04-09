class Solution {
    public int sumCounts(List<Integer> nums) {
        Set<Integer> set;
        int n = nums.size();
        int res = 0;

        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                res += Math.pow(set.size(), 2);
            }
        }

        return res;
    }
}