class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs((long) nums[i] - nums[j]) == k) {
                    int a = Math.min(nums[i], nums[j]);
                    int b = Math.max(nums[i], nums[j]);

                    String key = a + "," + b;

                    if (set.add(key)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
